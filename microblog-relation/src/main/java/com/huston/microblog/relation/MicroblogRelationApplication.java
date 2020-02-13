package com.huston.microblog.relation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.huston.microblog.relation.mapper")
public class MicroblogRelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroblogRelationApplication.class, args);
    }

}
