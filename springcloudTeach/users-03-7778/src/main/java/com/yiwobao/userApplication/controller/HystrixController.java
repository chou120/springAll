package com.yiwobao.userApplication.controller;

import com.yiwobao.userApplication.api.CommonResult;
import com.yiwobao.userApplication.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HystrixController {

    @Autowired
    private  ProductClient productClient;

    @GetMapping("/product/getByProductName")
    public CommonResult getByName(String name) {
        log.info("正在查询-->"+name+"<--商品,请稍后...");
        return productClient.getByName(name);
    }

}
