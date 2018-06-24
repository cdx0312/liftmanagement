package org.tio.examples.showcase.common.intf;

import org.tio.core.ChannelContext;
import org.tio.examples.showcase.common.ShowcasePacket;

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
	public Object handler(ShowcasePacket packet, ChannelContext channelContext) throws Exception;

}
