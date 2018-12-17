package com.hjh.tio.server.handler;

import java.util.concurrent.atomic.AtomicLong;

import com.hjh.tio.common.MyPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.core.ChannelContext;
import com.hjh.tio.common.MySessionContext;
import com.hjh.tio.common.Type;
import com.hjh.tio.common.intf.AbsShowcaseBsHandler;
import com.hjh.tio.common.packets.JoinGroupRespBody;
import com.hjh.tio.common.packets.LoginReqBody;
import com.hjh.tio.common.packets.LoginRespBody;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 * 2017年3月27日 下午9:51:28
 */
public class LoginReqHandler extends AbsShowcaseBsHandler<LoginReqBody> {
	private static Logger log = LoggerFactory.getLogger(LoginReqHandler.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	java.util.concurrent.atomic.AtomicLong tokenSeq = new AtomicLong();

	/**
	 *
	 * @author tanyaowu
	 */
	public LoginReqHandler() {
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public Class<LoginReqBody> bodyClass() {
		return LoginReqBody.class;
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
	public Object handler(MyPacket packet, LoginReqBody bsBody, ChannelContext channelContext) throws Exception {
		log.info("收到登录请求消息:{}", Json.toJson(bsBody));
		LoginRespBody loginRespBody = new LoginRespBody();
		loginRespBody.setCode(JoinGroupRespBody.Code.SUCCESS);
		loginRespBody.setToken(newToken());

		String userid = bsBody.getLoginname();
		Tio.bindUser(channelContext, userid);

		MySessionContext mySessionContext = (MySessionContext) channelContext.getAttribute();
		mySessionContext.setUserid(userid);

		MyPacket respPacket = new MyPacket();
		respPacket.setType(Type.LOGIN_RESP);
		respPacket.setBody(Json.toJson(loginRespBody).getBytes(MyPacket.CHARSET));
		Tio.send(channelContext, respPacket);

		return null;
	}

	private String newToken() {
		return System.currentTimeMillis() + "_" + tokenSeq.incrementAndGet();
	}
}
