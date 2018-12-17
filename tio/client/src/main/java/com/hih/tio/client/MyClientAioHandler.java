package com.hih.tio.client;

import java.util.HashMap;
import java.util.Map;

import com.hih.tio.client.handler.GroupMsgRespHandler;
import com.hih.tio.client.handler.JoinGroupRespHandler;
import com.hih.tio.client.handler.LiftInfoDetailRespHandler;
import com.hih.tio.client.handler.LiftInfoRespHandler;
import com.hih.tio.client.handler.LoginRespHandler;
import com.hih.tio.client.handler.P2PRespHandler;
import com.hjh.tio.common.MyAioHandler;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import com.hjh.tio.common.MyPacket;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;

/**
 * 客户端AIO处理器
 */
public class MyClientAioHandler extends MyAioHandler implements ClientAioHandler {
	// 将群组信息，加入群组，登录，P2P请求的四个处理器放入handlerMap中
	// 将电梯处理信息加入到群组
	private static Map<Byte, AbsShowcaseBsHandler<?>> handlerMap = new HashMap<>();
	static {
		handlerMap.put(Type.GROUP_MSG_RESP, new GroupMsgRespHandler());
		handlerMap.put(Type.JOIN_GROUP_RESP, new JoinGroupRespHandler());
		handlerMap.put(Type.LOGIN_RESP, new LoginRespHandler());
		handlerMap.put(Type.P2P_RESP, new P2PRespHandler());
		handlerMap.put(Type.SEND_LIFTINFORMATION_REQ, new LiftInfoRespHandler());
		handlerMap.put(Type.SEND_LIFTDETAIL_RESPONSE, new LiftInfoDetailRespHandler());
	}

	// 设置心跳包，body为空，类型为99
	private static MyPacket heartbeatPacket = new MyPacket(Type.HEART_BEAT_REQ, null);

	/**
	 * 处理消息
	 * @param packet 包类型
	 * @param channelContext
	 * @throws Exception
	 */
	@Override
	public void handler(Packet packet, ChannelContext channelContext) throws Exception {
		MyPacket myPacket = (MyPacket) packet;
		Byte type = myPacket.getType();
		AbsShowcaseBsHandler<?> showcaseBsHandler = handlerMap.get(type);
		showcaseBsHandler.handler(myPacket, channelContext);
	}

	/**
	 * 此方法如果返回null，框架层面则不会发心跳；如果返回非null，框架层面会定时发本方法返回的消息包
	 */
	@Override
	public MyPacket heartbeatPacket() {
		return heartbeatPacket;
	}
}
