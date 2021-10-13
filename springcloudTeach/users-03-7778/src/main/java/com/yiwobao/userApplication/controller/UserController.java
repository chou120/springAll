package com.yiwobao.userApplication.controller;

import com.netflix.loadbalancer.IRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @GetMapping("/user/findAll")
    public String findAll(){
        log.info("欢迎访问用户服务...");
        //1.使用restTemplate调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        /*String forObject = restTemplate.getForObject("http://localhost:7779/product/showInfo",
                String.class); *///返回值的响应类型
        /*String forObject = restTemplate.getForObject("http://localhost:7779/product/findAll",
                String.class);*/
        String forObject = restTemplate.getForObject("http://localhost:7780/product/findAll",
                String.class);
        return forObject;
    }


    /**
     * 使用discovery client  进行客户端调用
     * @return
     */
    @Autowired
    DiscoveryClient client;

    IRule  iRule;

    @Autowired
    LoadBalancerClient loadBalanceClient;

    @Autowired
    RestTemplate template;

    @GetMapping("/user/ribbon")
    public String testRibbon(){
        //获取注册中心中的实例的名称 也就是产品服务的名称 productClient
        //返回的是一个集合,为什么？ 因为集群 注册中心中可能有多个相关的实例(端口号可能不一样)
        /*List<ServiceInstance> productClient = client.getInstances("productClient");
        for (ServiceInstance serviceInstance : productClient) {
            System.out.println(serviceInstance.getHost());
            System.out.println(serviceInstance.getPort());
        }*/
        //2.
        /*ServiceInstance productClient = loadBalanceClient.choose("productClient");//使用默认的轮询策略
        String  url="http://"+productClient.getHost()+":"+productClient.getPort()+"/product/findAll";
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);*/

        //3.@LoadBalanced 调用客户端
        /**
         * url=http://注册中心的产品服务名/product/findAll
         */
        String forObject = template.getForObject("http://productClient/product/findAll", String.class);


        return  forObject;
    }

}
