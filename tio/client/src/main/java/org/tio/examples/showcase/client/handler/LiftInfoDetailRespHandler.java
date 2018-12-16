package org.tio.examples.showcase.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.examples.showcase.common.ShowcasePacket;
import org.tio.examples.showcase.common.intf.AbsShowcaseBsHandler;
import org.tio.examples.showcase.common.packets.LiftInfoDetailReqBody;
import org.tio.examples.showcase.common.packets.LiftInfoDetailRespBody;
import org.tio.examples.showcase.common.packets.LiftInformationRespBody;
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
	public Object handler(ShowcasePacket packet, LiftInfoDetailRespBody bsBody, ChannelContext channelContext) throws Exception {
		System.out.println("电梯详情信息：" + Json.toJson(bsBody));
		return null;
	}
}
