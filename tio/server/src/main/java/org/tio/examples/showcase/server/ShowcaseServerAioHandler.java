package org.tio.examples.showcase.server;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.examples.showcase.common.ShowcaseAbsAioHandler;
import org.tio.examples.showcase.common.ShowcasePacket;
import org.tio.examples.showcase.common.Type;
import org.tio.examples.showcase.common.intf.AbsShowcaseBsHandler;
import org.tio.examples.showcase.server.handler.*;
import org.tio.server.intf.ServerAioHandler;

/**
 *
 * @author tanyaowu
 *
 */
public class ShowcaseServerAioHandler extends ShowcaseAbsAioHandler implements ServerAioHandler {
	private static Logger log = LoggerFactory.getLogger(ShowcaseServerAioHandler.class);

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
		ShowcasePacket showcasePacket = (ShowcasePacket) packet;
		Byte type = showcasePacket.getType();
		AbsShowcaseBsHandler<?> showcaseBsHandler = handlerMap.get(type);
		if (showcaseBsHandler == null) {
			log.error("{}, 找不到处理类，type:{}", channelContext, type);
			return;
		}
		showcaseBsHandler.handler(showcasePacket, channelContext);
		return;
	}
}
