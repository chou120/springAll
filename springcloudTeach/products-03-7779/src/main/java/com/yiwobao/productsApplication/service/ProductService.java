package com.yiwobao.productsApplication.service;

import com.yiwobao.productsApplication.api.CommonResult;
import com.yiwobao.productsApplication.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {
    /**
     * 用来测试商品服务降级的
     * @param name
     * @return
     */
    CommonResult getByName(String name);

}
