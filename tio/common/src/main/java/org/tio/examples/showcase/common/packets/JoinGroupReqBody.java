package org.tio.examples.showcase.common.packets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 进群请求
 */
public class JoinGroupReqBody extends BaseBody {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(JoinGroupReqBody.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	private String group;

	public JoinGroupReqBody() {

	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
}
