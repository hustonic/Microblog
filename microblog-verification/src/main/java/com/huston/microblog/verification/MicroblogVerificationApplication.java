package com.huston.microblog.verification;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.huston.microblog.verification.mapper")
public class MicroblogVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroblogVerificationApplication.class, args);
    }

}
