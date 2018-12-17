package com.hjh.tio.server;

import java.util.HashMap;
import java.util.Map;

import com.hjh.tio.common.MyAioHandler;
import com.hjh.tio.common.MyPacket;
import com.hjh.tio.server.handler.GroupMsgReqHandler;
import com.hjh.tio.server.handler.HeartbeatReqHandler;
import com.hjh.tio.server.handler.JoinGroupReqHandler;
import com.hjh.tio.server.handler.LiftInfoDetailReqHandler;
import com.hjh.tio.server.handler.LiftInformationReqHandler;
import com.hjh.tio.server.handler.LoginReqHandler;
import com.hjh.tio.server.handler.P2PReqHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import org.tio.server.intf.ServerAioHandler;

/**
 *
 * @author tanyaowu
 *
 */
public class MyServerAioHandler extends MyAioHandler implements ServerAioHandler {
	private static Logger log = LoggerFactory.getLogger(MyServerAioHandler.class);

	private static Map<Byte, AbsShowcaseBsHandler<?>> handlerMap = new HashMap<>();
	static {
		handlerMap.put(Type.GROUP_MSG_REQ, new GroupMsgReqHandler());
		handlerMap.put(Type.HEART_BEAT_REQ, new HeartbeatReqHandler());
		handlerMap.put(Type.JOIN_GROUP_REQ, new JoinGroupReqHandler());
		handlerMap.put(Type.LOGIN_REQ, new LoginReqHandler());
		handlerMap.put(Type.P2P_REQ, new P2PReqHandler());
		handlerMap.put(Type.SEND_LIFTINFORMATION_REQ, new LiftInformationReqHandler());
		handlerMap.put(Type.SEND_LIFTDETAIL_REQUEST, new LiftInfoDetailReqHandler());
	}

	/**
	 * 处理消息
	 */
	@Override
	public void handler(Packet packet, ChannelContext channelContext) throws Exception {
		MyPacket myPacket = (MyPacket) packet;
		Byte type = myPacket.getType();
		AbsShowcaseBsHandler<?> showcaseBsHandler = handlerMap.get(type);
		if (showcaseBsHandler == null) {
			log.error("{}, 找不到处理类，type:{}", channelContext, type);
			return;
		}
		showcaseBsHandler.handler(myPacket, channelContext);
		return;
	}
}
