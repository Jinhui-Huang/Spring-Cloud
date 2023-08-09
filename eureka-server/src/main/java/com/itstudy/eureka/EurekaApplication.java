package com.itstudy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * className EurekaApplication
 * packageName com.itstudy.eureka
 * Description EurekaApplication注册中心, @EnableEurekaServer设置开启eureka服务即注册中心
 *
 * @author huian
 * @version 1.0
 * @Date: 2023/8/7 13:52
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
