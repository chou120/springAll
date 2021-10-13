package com.yiwobao.userApplication.client;



import com.yiwobao.userApplication.api.CommonResult;
import com.yiwobao.userApplication.entity.Product;
import com.yiwobao.userApplication.service.ProductFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="productClient",fallback = ProductFallback.class)//注册中心的服务名字
public interface ProductClient {

    /**
     * 调用产品服务的其中一个接口
     */
    @GetMapping("/product/findAll")
    Map<String,Object> findAll();
    /**
     * 根据productId查询
     */

    //注意:使用openFeign的Get方式传递参数,参数变量必须通过@RequestParam注解来进行修饰 （原理和springmvc传参一样）
    @GetMapping("/product/findByCondition")
     Map<String,Object> findByCondition(@RequestParam("productId") String productId);

    /**
     * 使用post方式传参
     */
    @PostMapping("/product/save")
    Map<String,Object> save(String name);


    /**
     * feign远程调用传参
     * @param product
     * @return
     */
    @PostMapping("/product/saveProduct")
    public Map<String,Object> saveProduct(@RequestBody Product product);


    /**
     * 用来测试openFeign + hystrix
     */
    @GetMapping("/product/getByName")
    CommonResult getByName(@RequestParam("name") String name);

}
