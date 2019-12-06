package com.peterwanghao.samples.integration.account;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.peterwanghao.samples.integration.account")
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan({"com.peterwanghao.samples.integration.account.mapper"})
@EnableDubbo(scanBasePackages = "com.peterwanghao.samples.integration.account")
public class AccountExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountExampleApplication.class, args);
    }

}

