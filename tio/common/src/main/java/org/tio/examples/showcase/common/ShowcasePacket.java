package org.tio.examples.showcase.common;

import org.tio.core.intf.Packet;

/**
 * 包结构，集成Packet类
 */
public class ShowcasePacket extends Packet {
	private static final long serialVersionUID = -5481926483435771100L;
	//消息头的长度 1+4
	public static final int HEADER_LENGTH = 5;
	// 字符编码方式
	public static final String CHARSET = "utf-8";

	/**
	 * 消息类型，其值在org.tio.examples.showcase.common.Type中定义
	 */
	private byte type;
	// body数组
	private byte[] body;

	public ShowcasePacket() {
		super();
	}

	/**
	 * @param type
	 * @param body
	 */
	public ShowcasePacket(byte type, byte[] body) {
		super();
		this.type = type;
		this.body = body;
	}

	/**
	 * @return the body
	 */
	public byte[] getBody() {
		return body;
	}

	/**
	 * @return the type
	 */
	public byte getType() {
		return type;
	}

	@Override
	public String logstr() {
		return "" + type;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(byte[] body) {
		this.body = body;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(byte type) {
		this.type = type;
	}
}
