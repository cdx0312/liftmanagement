package com.hih.tio.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.client.intf.ClientAioListener;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import com.hjh.tio.common.MySessionContext;
import org.tio.utils.json.Json;

/**
 * 客户端监听器
 */
public class MyClientAioListener implements ClientAioListener {
	private static Logger log = LoggerFactory.getLogger(MyClientAioListener.class);

	public static void main(String[] args) {

	}

	public MyClientAioListener() {
	}


	/**
	 * 连接之后
	 * @param channelContext
	 * @param isConnected
	 * @param isReconnect
	 * @throws Exception
	 */
	@Override
	public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
		log.info("onAfterConnected channelContext:{}, isConnected:{}, isReconnect:{}", channelContext, isConnected, isReconnect);

		//连接后，需要把连接会话对象设置给channelContext
		channelContext.setAttribute(new MySessionContext());
	}


	/**
	 * 发送之后
	 * @param channelContext
	 * @param packet
	 * @param isSentSuccess
	 * @throws Exception
	 */
	@Override
	public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
		log.info("onAfterSent channelContext:{}, packet:{}, isSentSuccess:{}", channelContext, Json.toJson(packet), isSentSuccess);
	}

	/**
	 * 关闭之前
	 * @param channelContext
	 * @param throwable
	 * @param remark
	 * @param isRemove
	 */
	@Override
	public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) {
	}


	/**
	 * 解码之后
	 * @param channelContext
	 * @param packet
	 * @param packetSize
	 * @throws Exception
	 */
	@Override
	public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
	}


	/**
	 * 接受完字节数组之后
	 * @param channelContext
	 * @param receivedBytes
	 * @throws Exception
	 */
	@Override
	public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {
	}


	/**
	 * 处理网之后
	 * @param channelContext
	 * @param packet
	 * @param cost
	 * @throws Exception
	 */
	@Override
	public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {
	}

}
