package com.hih.tio.client.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.LiftInformationRespBody;
import org.tio.utils.json.Json;


public class LiftInfoRespHandler extends AbsShowcaseBsHandler<LiftInformationRespBody> {

	private static Logger log = LoggerFactory.getLogger(LiftInformationRespBody.class);


	public static void main(String[] args) {
	}

	public LiftInfoRespHandler() {
	}

	@Override
	public Class<LiftInformationRespBody> bodyClass() {
		return LiftInformationRespBody.class;
	}

	/**
	 *  实现获取服务端请求的handler接口
	 * @param packet 收到的包
	 * @param liftInformationRespBody  Response实体
	 * @param channelContext
	 * @return 空
	 * @throws Exception
	 */
	@Override
	public Object handler(MyPacket packet, LiftInformationRespBody liftInformationRespBody, ChannelContext channelContext) throws Exception {
		System.out.println("收到群组消息:" + Json.toJson(liftInformationRespBody));
		return null;
	}
}
