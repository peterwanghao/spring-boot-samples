package com.peterwanghao.sample.greeter.sampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.peterwanghao.samples.greeter.library.Greeter;

/**
 * @ClassName: GreeterSampleApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年2月27日 上午11:00:18
 * @version V1.0
 * 
 */
@SpringBootApplication
public class GreeterSampleApplication implements CommandLineRunner {
	@Autowired
	private Greeter greeter;

	public static void main(String[] args) {
		SpringApplication.run(GreeterSampleApplication.class, args);
	}

	public void run(String... args) throws Exception {
		String message = greeter.greet();
		System.out.println(message);
	}
}
