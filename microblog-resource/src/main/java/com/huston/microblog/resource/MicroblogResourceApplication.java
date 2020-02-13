package com.huston.microblog.resource;

import org.apache.commons.net.ftp.FTPClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.huston.microblog.resource.mapper")
public class MicroblogResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroblogResourceApplication.class, args);
    }

}
