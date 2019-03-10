package com.hjh.tio.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.MyPacket;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.GroupMsgReqBody;

/**
 * 心跳处理
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class HeartbeatReqHandler extends AbsShowcaseBsHandler<GroupMsgReqBody> {
	private static Logger log = LoggerFactory.getLogger(HeartbeatReqHandler.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @author tanyaowu
	 */
	public HeartbeatReqHandler() {
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public Class<GroupMsgReqBody> bodyClass() {
		return GroupMsgReqBody.class;
	}

	/**
	 * @param packet
	 * @param bsBody
	 * @param channelContext
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public Object handler(MyPacket packet, GroupMsgReqBody bsBody, ChannelContext channelContext) throws Exception {
		//心跳消息,啥也不用做
		return null;
	}
}
