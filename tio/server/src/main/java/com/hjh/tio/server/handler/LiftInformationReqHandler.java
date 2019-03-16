package com.hjh.tio.server.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.LiftInformationReqBody;
import com.hjh.tio.common.packets.LiftInformationRespBody;
import com.hjh.tio.server.activemqProducer.ActivemqProducer;
import org.tio.utils.json.Json;

public class LiftInformationReqHandler extends AbsShowcaseBsHandler<LiftInformationReqBody> {
	private static Logger log = LoggerFactory.getLogger(LiftInformationReqHandler.class);

	private ActivemqProducer activemqProducer = new ActivemqProducer();

	public static void main(String[] args) {
	}

	public LiftInformationReqHandler() {
	}

	@Override
	public Class<LiftInformationReqBody> bodyClass() {
		return LiftInformationReqBody.class;
	}

	@Override
	public Object handler(MyPacket packet, LiftInformationReqBody liftInformationReqBody, ChannelContext channelContext) throws Exception {
		log.info("获取到的电梯数据信息:{}", Json.toJson(liftInformationReqBody));
		// 将电梯数据发送到队列
		activemqProducer.sendQueueProducer(Json.toJson(liftInformationReqBody));
		LiftInformationRespBody liftInformationRespBody = new LiftInformationRespBody();
		liftInformationRespBody.setCode(200);
		liftInformationRespBody.setMsg(liftInformationReqBody.toString());
		liftInformationRespBody.setLiftStatus(String.valueOf(liftInformationReqBody.getSpeed()));

		MyPacket respPacket = new MyPacket();
		respPacket.setType(Type.SEND_LIFTINFORMATION_REQ);
		respPacket.setTimestamp(System.currentTimeMillis());
		respPacket.setBody(Json.toJson(liftInformationRespBody).getBytes(MyPacket.CHARSET));
		Tio.send(channelContext, respPacket);
		return null;
	}
}
