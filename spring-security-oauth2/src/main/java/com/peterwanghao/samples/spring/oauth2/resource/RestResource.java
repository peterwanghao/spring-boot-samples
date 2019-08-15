package com.peterwanghao.samples.spring.oauth2.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: RestResource
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年8月15日 下午1:43:35
 * @version V1.0
 * 
 */
@Controller
public class RestResource {
	@RequestMapping("/api/users/me")
	public ResponseEntity<UserInfo> profile() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = user.getUsername() + "@126.com";

		UserInfo profile = new UserInfo();
		profile.setName(user.getUsername());
		profile.setEmail(email);

		return ResponseEntity.ok(profile);
	}
}
