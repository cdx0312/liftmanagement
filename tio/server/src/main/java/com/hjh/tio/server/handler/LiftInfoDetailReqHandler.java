package com.hjh.tio.server.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.LiftInfoDetailReqBody;
import com.hjh.tio.common.packets.LiftInfoDetailRespBody;
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
	public Object handler(MyPacket packet, LiftInfoDetailReqBody liftInfoDetailReqBody, ChannelContext channelContext) throws Exception {
		log.info("获取到的电梯数据信息:{}", Json.toJson(liftInfoDetailReqBody));
		LiftInfoDetailRespBody liftInfoDetailRespBody = new LiftInfoDetailRespBody();
		liftInfoDetailRespBody.setCode(200);
		liftInfoDetailRespBody.setMsg(Json.toJson(liftInfoDetailReqBody));
		liftInfoDetailRespBody.setLiftStatus("success");

		MyPacket respPacket = new MyPacket();
		respPacket.setType(Type.SEND_LIFTDETAIL_RESPONSE);
		respPacket.setBody(Json.toJson(liftInfoDetailRespBody).getBytes(MyPacket.CHARSET));
		Tio.send(channelContext, respPacket);
		return null;
	}
}
