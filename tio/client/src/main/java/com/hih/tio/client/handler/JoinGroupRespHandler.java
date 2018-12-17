package com.hih.tio.client.handler;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.JoinGroupRespBody;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class JoinGroupRespHandler extends AbsShowcaseBsHandler<JoinGroupRespBody> {
	private static Logger log = LoggerFactory.getLogger(JoinGroupRespHandler.class);

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
	public JoinGroupRespHandler() {
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public Class<JoinGroupRespBody> bodyClass() {
		return JoinGroupRespBody.class;
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
	public Object handler(MyPacket packet, JoinGroupRespBody bsBody, ChannelContext channelContext) throws Exception {
		System.out.println("收到进群响应消息:" + Json.toJson(bsBody));

		if (JoinGroupRespBody.Code.SUCCESS.equals(bsBody.getCode())) {
			Tio.bindGroup(channelContext, bsBody.getGroup());
			System.out.println("进入群组[" + bsBody.getGroup() + "]成功");
		}

		return null;
	}
}
