package com.yiwobao.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;

@SpringBootApplication
@EnableDiscoveryClient //注解 默认不需要
public class GetwayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class,args);
    }
}
