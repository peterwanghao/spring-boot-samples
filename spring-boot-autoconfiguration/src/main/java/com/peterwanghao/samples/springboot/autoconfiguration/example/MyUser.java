package com.peterwanghao.samples.springboot.autoconfiguration.example;

import javax.persistence.Entity;
import javax.persistence.Id;

/**   
 * @ClassName:  MyUser
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年2月21日 下午4:45:15
 * @version V1.0
 * 
 */
@Entity
public class MyUser {
	@Id
	private String email;

	public MyUser() {
	}

	public MyUser(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
