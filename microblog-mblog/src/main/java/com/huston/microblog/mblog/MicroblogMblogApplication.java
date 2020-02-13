package com.huston.microblog.mblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.huston.microblog.mblog.mapper")
@EnableAsync
public class MicroblogMblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroblogMblogApplication.class, args);
    }

}
