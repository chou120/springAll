package com.yiwobao.userApplication.service;

import com.yiwobao.userApplication.api.CommonResult;
import com.yiwobao.userApplication.client.ProductClient;
import com.yiwobao.userApplication.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ProductFallback implements ProductClient {
    @Override
    public Map<String, Object> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> findByCondition(String productId) {
        return null;
    }

    @Override
    public Map<String, Object> save(String name) {
        return null;
    }

    @Override
    public Map<String, Object> saveProduct(Product product) {
        return null;
    }

    @Override
    public CommonResult getByName(String name) {
        return CommonResult.failed("[我是用户服务]---服务繁忙,不可用,请稍后再试....");
    }
}
