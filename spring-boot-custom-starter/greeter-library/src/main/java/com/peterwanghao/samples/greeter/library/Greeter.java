package com.peterwanghao.samples.greeter.library;

import static com.peterwanghao.samples.greeter.library.GreeterConfigParams.*;
import java.time.LocalDateTime;

/**
 * @ClassName: Greeter
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年2月27日 上午9:33:27
 * @version V1.0
 * 
 */
public class Greeter {
	private GreetingConfig greetingConfig;

	public Greeter(GreetingConfig greetingConfig) {
		this.greetingConfig = greetingConfig;
	}

	public String greet(LocalDateTime localDateTime) {

		String name = greetingConfig.getProperty(USER_NAME);
		int hourOfDay = localDateTime.getHour();

		if (hourOfDay >= 5 && hourOfDay < 12) {
			return String.format("Hello %s, %s", name, greetingConfig.get(MORNING_MESSAGE));
		} else if (hourOfDay >= 12 && hourOfDay < 17) {
			return String.format("Hello %s, %s", name, greetingConfig.get(AFTERNOON_MESSAGE));
		} else if (hourOfDay >= 17 && hourOfDay < 20) {
			return String.format("Hello %s, %s", name, greetingConfig.get(EVENING_MESSAGE));
		} else {
			return String.format("Hello %s, %s", name, greetingConfig.get(NIGHT_MESSAGE));
		}
	}

	public String greet() {
		return greet(LocalDateTime.now());
	}
}
