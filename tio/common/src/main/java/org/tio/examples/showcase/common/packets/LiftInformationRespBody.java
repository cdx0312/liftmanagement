package org.tio.examples.showcase.common.packets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 进群响应
 */
public class LiftInformationRespBody extends BaseBody {
	public static interface Code {
		Integer SUCCESS = 1;
		Integer FAIL = 2;
	}

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(LiftInformationRespBody.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	// code结果，200表示正常
	private Integer code;

	// msg信息
	private String msg;

	// 电梯状态信息
	private String liftStatus;

	public LiftInformationRespBody() {
	}

	public LiftInformationRespBody(Integer code, String msg, String liftStatus) {
		this.code = code;
		this.msg = msg;
		this.liftStatus = liftStatus;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		LiftInformationRespBody.log = log;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLiftStatus() {
		return liftStatus;
	}

	public void setLiftStatus(String liftStatus) {
		this.liftStatus = liftStatus;
	}
}
