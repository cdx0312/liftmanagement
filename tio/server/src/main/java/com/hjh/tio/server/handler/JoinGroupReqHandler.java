package com.hjh.tio.server.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.JoinGroupReqBody;
import com.hjh.tio.common.packets.JoinGroupRespBody;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class JoinGroupReqHandler extends AbsShowcaseBsHandler<JoinGroupReqBody> {
	private static Logger log = LoggerFactory.getLogger(JoinGroupReqHandler.class);

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
	public JoinGroupReqHandler() {
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public Class<JoinGroupReqBody> bodyClass() {
		return JoinGroupReqBody.class;
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
	public Object handler(MyPacket packet, JoinGroupReqBody bsBody, ChannelContext channelContext) throws Exception {
		log.info("收到进群请求消息:{}", Json.toJson(bsBody));
		JoinGroupRespBody joinGroupRespBody = new JoinGroupRespBody();
		joinGroupRespBody.setCode(JoinGroupRespBody.Code.SUCCESS);
		joinGroupRespBody.setGroup(bsBody.getGroup());

		Tio.bindGroup(channelContext, bsBody.getGroup());

		MyPacket respPacket = new MyPacket();
		respPacket.setType(Type.JOIN_GROUP_RESP);
		respPacket.setTimestamp(System.currentTimeMillis());
		respPacket.setBody(Json.toJson(joinGroupRespBody).getBytes(MyPacket.CHARSET));
		Tio.send(channelContext, respPacket);
		return null;
	}
}
