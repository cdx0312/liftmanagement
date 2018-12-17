package com.hjh.tio.common.packets;

/**
 *
 */
public class BaseBody {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * 消息发送时间
	 */
	private Long time = System.currentTimeMillis();

	/**
	 *
	 */
	public BaseBody() {
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}
}
