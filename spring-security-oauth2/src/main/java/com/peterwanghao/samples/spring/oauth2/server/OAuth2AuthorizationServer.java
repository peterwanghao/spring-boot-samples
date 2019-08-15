package com.peterwanghao.samples.spring.oauth2.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @ClassName: OAuth2AuthorizationServer
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年8月15日 下午2:27:44
 * @version V1.0
 * 
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer
		extends
			AuthorizationServerConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security)
			throws Exception {
		security.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		clients.inMemory().withClient("clientapp")
				.secret(passwordEncoder.encode("654321"))
				.authorizedGrantTypes("password", "authorization_code",
						"refresh_token")
				.authorities("READ_ONLY_CLIENT").scopes("read_user_info")
				.resourceIds("oauth2-resource")
				.redirectUris("http://localhost:8081/login")
				.accessTokenValiditySeconds(5000)
				.refreshTokenValiditySeconds(50000);
	}
}