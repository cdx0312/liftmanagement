package org.tio.examples.showcase.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.examples.showcase.common.ShowcasePacket;
import org.tio.examples.showcase.common.Type;
import org.tio.examples.showcase.common.intf.AbsShowcaseBsHandler;
import org.tio.examples.showcase.common.packets.LiftInfoDetailReqBody;
import org.tio.examples.showcase.common.packets.LiftInfoDetailRespBody;
import org.tio.examples.showcase.common.packets.LiftInformationReqBody;
import org.tio.examples.showcase.common.packets.LiftInformationRespBody;
import org.tio.examples.showcase.server.activemqProducer.ActivemqProducer;
import org.tio.utils.json.Json;

public class LiftInfoDetailReqHandler extends AbsShowcaseBsHandler<LiftInfoDetailReqBody> {
	private static Logger log = LoggerFactory.getLogger(LiftInfoDetailReqHandler.class);

	public LiftInfoDetailReqHandler() {
	}

	@Override
	public Class<LiftInfoDetailReqBody> bodyClass() {
		return LiftInfoDetailReqBody.class;
	}

	@Override
	public Object handler(ShowcasePacket packet, LiftInfoDetailReqBody liftInfoDetailReqBody, ChannelContext channelContext) throws Exception {
		log.info("获取到的电梯数据信息:{}", Json.toJson(liftInfoDetailReqBody));
		LiftInfoDetailRespBody liftInfoDetailRespBody = new LiftInfoDetailRespBody();
		liftInfoDetailRespBody.setCode(200);
		liftInfoDetailRespBody.setMsg(Json.toJson(liftInfoDetailReqBody));
		liftInfoDetailRespBody.setLiftStatus("success");

		ShowcasePacket respPacket = new ShowcasePacket();
		respPacket.setType(Type.SEND_LIFTDETAIL_RESPONSE);
		respPacket.setBody(Json.toJson(liftInfoDetailRespBody).getBytes(ShowcasePacket.CHARSET));
		Tio.send(channelContext, respPacket);
		return null;
	}
}
