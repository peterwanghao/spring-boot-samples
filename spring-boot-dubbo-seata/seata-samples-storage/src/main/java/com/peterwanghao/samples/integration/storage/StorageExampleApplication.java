package com.peterwanghao.samples.integration.storage;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.peterwanghao.samples.integration.storage")
@EnableDiscoveryClient
@MapperScan({"com.peterwanghao.samples.integration.storage.mapper"})
@EnableDubbo(scanBasePackages = "com.peterwanghao.samples.integration.storage")
public class StorageExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageExampleApplication.class, args);
    }

}

