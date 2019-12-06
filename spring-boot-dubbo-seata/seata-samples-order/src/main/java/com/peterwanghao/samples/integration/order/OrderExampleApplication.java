package com.peterwanghao.samples.integration.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.peterwanghao.samples.integration.order")
@EnableDiscoveryClient
@MapperScan({"com.peterwanghao.samples.integration.order.mapper"})
@EnableDubbo(scanBasePackages = "com.peterwanghao.samples.integration.order")
public class OrderExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderExampleApplication.class, args);
    }

}

