package com.peterwanghao.samples.greeter.autoconfigure;

import static com.peterwanghao.samples.greeter.library.GreeterConfigParams.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import com.peterwanghao.samples.greeter.library.Greeter;
import com.peterwanghao.samples.greeter.library.GreetingConfig;

/**
 * @ClassName: GreeterAutoConfiguration
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年2月27日 上午10:08:51
 * @version V1.0
 * 
 */
public class GreeterAutoConfiguration {
	@Autowired
	private GreeterProperties greeterProperties;

	@Bean
	@ConditionalOnMissingBean
	public GreetingConfig greeterConfig() {

		String userName = greeterProperties.getUserName() == null ? System.getProperty("user.name")
				: greeterProperties.getUserName();
		String morningMessage = greeterProperties.getMorningMessage() == null ? "Good Morning"
				: greeterProperties.getMorningMessage();
		String afternoonMessage = greeterProperties.getAfternoonMessage() == null ? "Good Afternoon"
				: greeterProperties.getAfternoonMessage();
		String eveningMessage = greeterProperties.getEveningMessage() == null ? "Good Evening"
				: greeterProperties.getEveningMessage();
		String nightMessage = greeterProperties.getNightMessage() == null ? "Good Night"
				: greeterProperties.getNightMessage();

		GreetingConfig greetingConfig = new GreetingConfig();
		greetingConfig.put(USER_NAME, userName);
		greetingConfig.put(MORNING_MESSAGE, morningMessage);
		greetingConfig.put(AFTERNOON_MESSAGE, afternoonMessage);
		greetingConfig.put(EVENING_MESSAGE, eveningMessage);
		greetingConfig.put(NIGHT_MESSAGE, nightMessage);
		return greetingConfig;
	}

	@Bean
	@ConditionalOnMissingBean
	public Greeter greeter(GreetingConfig greetingConfig) {
		return new Greeter(greetingConfig);
	}
}
