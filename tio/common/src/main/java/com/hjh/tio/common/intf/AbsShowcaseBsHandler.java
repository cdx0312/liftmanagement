package com.hjh.tio.common.intf;

import com.hjh.tio.common.Const;
import com.hjh.tio.common.MyPacket;
import com.hjh.tio.common.packets.BaseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.utils.json.Json;


public abstract class AbsShowcaseBsHandler<T extends BaseBody> implements ShowcaseBsHandlerIntf {
	private static Logger log = LoggerFactory.getLogger(AbsShowcaseBsHandler.class);

	public AbsShowcaseBsHandler() {
	}

	public abstract Class<T> bodyClass();

	@Override
	public Object handler(MyPacket packet, ChannelContext channelContext) throws Exception {
		String jsonStr = null;
		T bsBody = null;
		if (packet.getBody() != null) {
			jsonStr = new String(packet.getBody(), Const.CHARSET);
			bsBody = Json.toBean(jsonStr, bodyClass());
		}

		return handler(packet, bsBody, channelContext);
	}

	public abstract Object handler(MyPacket packet, T bsBody, ChannelContext channelContext) throws Exception;

}
