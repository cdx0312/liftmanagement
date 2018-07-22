package org.tio.examples.showcase.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.examples.showcase.common.ShowcasePacket;
import org.tio.examples.showcase.common.Type;
import org.tio.examples.showcase.common.intf.AbsShowcaseBsHandler;
import org.tio.examples.showcase.common.packets.GroupMsgReqBody;
import org.tio.examples.showcase.common.packets.GroupMsgRespBody;
import org.tio.examples.showcase.common.packets.LiftInformationReqBody;
import org.tio.examples.showcase.common.packets.LiftInformationRespBody;
import org.tio.utils.json.Json;

public class LiftInformationReqHandler extends AbsShowcaseBsHandler<LiftInformationReqBody> {
	private static Logger log = LoggerFactory.getLogger(LiftInformationReqHandler.class);

	public static void main(String[] args) {
	}

	public LiftInformationReqHandler() {
	}

	@Override
	public Class<LiftInformationReqBody> bodyClass() {
		return LiftInformationReqBody.class;
	}

	@Override
	public Object handler(ShowcasePacket packet, LiftInformationReqBody liftInformationReqBody, ChannelContext channelContext) throws Exception {
		log.info("获取到的电梯数据信息:{}", Json.toJson(liftInformationReqBody));
		LiftInformationRespBody liftInformationRespBody = new LiftInformationRespBody();
		liftInformationRespBody.setCode(200);
		liftInformationRespBody.setMsg(liftInformationReqBody.toString());
		liftInformationRespBody.setLiftStatus(String.valueOf(liftInformationReqBody.getSpeed()));

		ShowcasePacket respPacket = new ShowcasePacket();
		respPacket.setType(Type.SEND_LIFTINFOMATION_REQ);
		respPacket.setBody(Json.toJson(liftInformationRespBody).getBytes(ShowcasePacket.CHARSET));
		Tio.send(channelContext, respPacket);
		return null;
	}
}
