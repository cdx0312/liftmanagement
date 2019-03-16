package com.hjh.tio.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.MyPacket;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.GroupMsgReqBody;
import com.hjh.tio.common.packets.GroupMsgRespBody;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class GroupMsgReqHandler extends AbsShowcaseBsHandler<GroupMsgReqBody> {
	private static Logger log = LoggerFactory.getLogger(GroupMsgReqHandler.class);

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
	public GroupMsgReqHandler() {
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
		log.info("收到群聊请求消息:{}", Json.toJson(bsBody));
		GroupMsgRespBody groupMsgRespBody = new GroupMsgRespBody();
		groupMsgRespBody.setText(bsBody.getText());
		groupMsgRespBody.setToGroup(bsBody.getToGroup());

		MyPacket respPacket = new MyPacket();
		respPacket.setType(Type.GROUP_MSG_RESP);
		respPacket.setTimestamp(System.currentTimeMillis());
		respPacket.setBody(Json.toJson(groupMsgRespBody).getBytes(MyPacket.CHARSET));
		Tio.sendToGroup(channelContext.groupContext, bsBody.getToGroup(), respPacket);

		return null;
	}
}
