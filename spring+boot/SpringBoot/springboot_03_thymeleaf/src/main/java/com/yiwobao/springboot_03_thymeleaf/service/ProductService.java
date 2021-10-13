package com.yiwobao.springboot_03_thymeleaf.service;

import com.yiwobao.springboot_03_thymeleaf.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product  addProduct(Product product);

    void  deleteByProduct(String pname);

    void updateByProduct(Product product);

}
