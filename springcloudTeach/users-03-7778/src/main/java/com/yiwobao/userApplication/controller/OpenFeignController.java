package com.yiwobao.userApplication.controller;

import com.yiwobao.userApplication.client.ProductClient;
import com.yiwobao.userApplication.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class OpenFeignController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/test/openFeign")
    public Map<String, Object> testOpenFeign() {
        Map<String, Object> all = productClient.findAll();
        all.put("code", "测试成功");
        return all;
    }

    @GetMapping("/test/findByCondition")
    public Map<String, Object> testFindByCondition(String productId) {

        log.info("我进来啦..." + productId);

        Map<String, Object> byCondition = productClient.findByCondition(productId);

        return byCondition;
    }

    @GetMapping("/test/save")
    public Map<String, Object> save(String name) {

        log.info("我进来啦..." + name);

        Map<String, Object> byCondition = productClient.findByCondition(name);

        return byCondition;
    }

    @GetMapping("/test/saveEntity")
    public Map<String, Object> saveEntity(Product product) {
        log.info("我进来啦..." + product);
        Map<String, Object> byCondition = productClient.saveProduct(product);
        return byCondition;
    }


}
