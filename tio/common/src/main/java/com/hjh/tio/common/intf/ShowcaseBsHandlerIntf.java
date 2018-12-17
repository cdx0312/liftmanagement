package com.hjh.tio.common.intf;

import com.hjh.tio.common.MyPacket;
import org.tio.core.ChannelContext;

/**
 * 业务处理器接口
 */
public interface ShowcaseBsHandlerIntf {

	/**
	 * 业务处理方法
	 * @param packet 数据包
	 * @param channelContext 上下文
	 * @return Object 类
	 * @throws Exception 异常抛出
	 */
	public Object handler(MyPacket packet, ChannelContext channelContext) throws Exception;

}
