package org.tio.examples.showcase.common;

import java.nio.ByteBuffer;

import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.AioHandler;
import org.tio.core.intf.Packet;

/**
 * ShowcaseAbsAioHandler 实现AioHandler接口的方法
 * 完成编码和解码
 */
public abstract class ShowcaseAbsAioHandler implements AioHandler {
	/**
	 * 解码：把接收到的ByteBuffer，解码成应用可以识别的业务消息包
	 * 消息头：type + bodyLength
	 * 消息体：byte[]
	 * @param buffer ByteBuffer缓冲区数据
	 * @param limit
	 * @param position
	 * @param readableLength 可读数据长度
	 * @param channelContext
	 * @return ShowcasePacket 返回解码之后的showcasePacket
	 * @throws AioDecodeException Aio解码异常
	 */
	@Override
	public ShowcasePacket decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext) throws AioDecodeException {
		//可读数据，小于头部的固定长度，直接返回null，这样tio框架会自动把本次收到的数据暂存起来，并和下次收到的数据组合起来
		if (readableLength < ShowcasePacket.HEADER_LENGTH) {
			return null;
		}

		//position的值不一定是0
		//消息类型
		byte type = buffer.get();

		int bodyLength = buffer.getInt();

		if (bodyLength < 0) {
			throw new AioDecodeException("bodyLength [" + bodyLength + "] is not right, remote:" + channelContext.getClientNode());
		}

		int neededLength = ShowcasePacket.HEADER_LENGTH + bodyLength;
		int test = readableLength - neededLength;
		if (test < 0) // 不够消息体长度(剩下的buffe组不了消息体)
		{
			return null;
		} else {
			ShowcasePacket imPacket = new ShowcasePacket();
			imPacket.setType(type);
			if (bodyLength > 0) {
				byte[] dst = new byte[bodyLength];
				buffer.get(dst);
				imPacket.setBody(dst);
			}
			return imPacket;
		}
	}

	/**
	 *  编码：把业务消息包编码为可以发送的ByteBuffer
	 * 消息头：type + bodyLength
	 * 消息体：byte[]
	 * @param packet 要编码的包
	 * @param groupContext
	 * @param channelContext
	 * @return
	 */
	@Override
	public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
		//  强制转换
		ShowcasePacket showcasePacket = (ShowcasePacket) packet;
		// 从包中获取body字节数组
		byte[] body = showcasePacket.getBody();
		int bodyLen = 0;
		if (body != null) {
			bodyLen = body.length;
		}

		//总长度是  消息头的长度+消息体的长度
		int allLen = ShowcasePacket.HEADER_LENGTH + bodyLen;
		// 分配字节缓冲区并填充
		ByteBuffer buffer = ByteBuffer.allocate(allLen);
		buffer.order(groupContext.getByteOrder());

		//写入消息类型
		buffer.put(showcasePacket.getType());
		//写入消息体长度
		buffer.putInt(bodyLen);

		//写入消息体
		if (body != null) {
			buffer.put(body);
		}
		return buffer;
	}
}
