package com.hih.tio.client.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.LiftInfoDetailRespBody;
import com.hjh.tio.common.packets.LiftInformationRespBody;
import org.tio.utils.json.Json;


public class LiftInfoDetailRespHandler extends AbsShowcaseBsHandler<LiftInfoDetailRespBody> {

	private static Logger log = LoggerFactory.getLogger(LiftInformationRespBody.class);


	public static void main(String[] args) {
	}

	public LiftInfoDetailRespHandler() {
	}

	@Override
	public Class<LiftInfoDetailRespBody> bodyClass() {
		return LiftInfoDetailRespBody.class;
	}

	@Override
	public Object handler(MyPacket packet, LiftInfoDetailRespBody bsBody, ChannelContext channelContext) throws Exception {
		System.out.println("电梯详情信息：" + Json.toJson(bsBody));
		return null;
	}
}
