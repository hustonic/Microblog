package com.huston.microblog.comment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.huston.microblog.comment.mapper")
public class MicroblogCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroblogCommentApplication.class, args);
    }

}
