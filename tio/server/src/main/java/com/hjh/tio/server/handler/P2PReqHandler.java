package com.hjh.tio.server.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.MySessionContext;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.P2PReqBody;
import com.hjh.tio.common.packets.P2PRespBody;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class P2PReqHandler extends AbsShowcaseBsHandler<P2PReqBody> {
	private static Logger log = LoggerFactory.getLogger(P2PReqHandler.class);

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
	public P2PReqHandler() {
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public Class<P2PReqBody> bodyClass() {
		return P2PReqBody.class;
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
	public Object handler(MyPacket packet, P2PReqBody bsBody, ChannelContext channelContext) throws Exception {
		log.info("收到点对点请求消息:{}", Json.toJson(bsBody));

		MySessionContext mySessionContext = (MySessionContext) channelContext.getAttribute();

		P2PRespBody p2pRespBody = new P2PRespBody();
		p2pRespBody.setFromUserid(mySessionContext.getUserid());
		p2pRespBody.setText(bsBody.getText());

		MyPacket respPacket = new MyPacket();
		respPacket.setType(Type.P2P_RESP);
		respPacket.setTimestamp(System.currentTimeMillis());
		respPacket.setBody(Json.toJson(p2pRespBody).getBytes(MyPacket.CHARSET));
		Tio.sendToUser(channelContext.groupContext, bsBody.getToUserid(), respPacket);

		return null;
	}
}
