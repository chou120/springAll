package com.yiwobao.userApplication.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced //代表Ribbon负载均衡RestTamplate哭护短对象
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
