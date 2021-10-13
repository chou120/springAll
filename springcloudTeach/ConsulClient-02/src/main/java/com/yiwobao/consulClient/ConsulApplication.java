package com.yiwobao.consulClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //开启服务注册功能  这个注解默认的
@SpringBootApplication
public class ConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class,args);
    }

}
