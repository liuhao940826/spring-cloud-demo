package self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启euraka客户端  这个就是eureka
//@EnableDiscoveryClient//开启服务发现客户端  这个可以是其他的注册中心
//这两个其实也可以都不添加
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
