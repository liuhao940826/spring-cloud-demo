package com.self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启fegin客户端
//@EnableEurekaClient//开启euraka客户端  这个就是eureka
@EnableDiscoveryClient//开启服务发现客户端  这个可以是其他的注册中心
@EnableCircuitBreaker//Hystrix
@EnableHystrixDashboard//Hystrix 控制台
//这两个其实也可以都不添加
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
