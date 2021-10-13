package com.yiwobao.springboot_03_thymeleaf.dao;

import com.yiwobao.springboot_03_thymeleaf.pojo.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ProductDao {
    List<Product> getAll();
    Product  addProduct(Product product);
    void  deleteByProduct(String pname);
    void updateByProduct(Product product);
    Product  getByName(String name);
}
