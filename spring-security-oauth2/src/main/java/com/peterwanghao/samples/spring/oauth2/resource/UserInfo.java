package com.peterwanghao.samples.spring.oauth2.resource;

/**
 * @ClassName: User
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年8月15日 下午1:25:36
 * @version V1.0
 * 
 */
public class UserInfo {
	private String name;
	private String email;

	/**
	 * @Title: getName <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Title: setName <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @Title: getEmail <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @Title: setEmail <BR>
	 * @Description: please write your description <BR>
	 * @return: String <BR>
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
}
