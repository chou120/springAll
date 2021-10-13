package com.yiwobao.productsApplication.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yiwobao.productsApplication.api.CommonResult;
import com.yiwobao.productsApplication.entity.Product;
import com.yiwobao.productsApplication.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "HystrixComResult")
//如果在类上使用降级之后的返回方法  方法作为公共的使用 就不能带有任何参数 否则访问的时候就容易报错
public class HystrixProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/getByName")
    @HystrixCommand
    public CommonResult getByName(String name) {
        return productService.getByName(name);
    }
    //降级的方法必须和受保护的方法的参数以及返回值类型一致
    public CommonResult HystrixComResult(){
        return  CommonResult.failed("业务繁忙,轻稍后再试...");
    }
}
