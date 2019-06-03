package com.self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   // 开启Eureka服务
public class EurekaClusterServerApplication03 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterServerApplication03.class, args);
    }
}
