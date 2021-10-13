package com.yiwobao.productsApplication.service;

import com.yiwobao.productsApplication.api.CommonResult;
import com.yiwobao.productsApplication.api.ResultCode;
import com.yiwobao.productsApplication.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService{
    //模拟数据库  初始化数据
    private static final List<Product> list=new ArrayList<Product>(){
        {
            add(new Product(1, "黄鱼", new Date()));
            add(new Product(2, "健力宝", new Date()));
            add(new Product(3, "辣条", new Date()));
        }
    };

    @Override
    public CommonResult getByName(String name) {
        Optional<Product> first = list.stream().filter(product -> product.getName().equals(name)).findFirst();
        if(first.isPresent()){
            return CommonResult.success(first.get());
        }
        return CommonResult.failed(ResultCode.FAILED,"您查找的商品不存在");
    }

}
