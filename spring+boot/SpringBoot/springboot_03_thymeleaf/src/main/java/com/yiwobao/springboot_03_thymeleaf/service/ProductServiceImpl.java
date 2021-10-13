package com.yiwobao.springboot_03_thymeleaf.service;

import com.yiwobao.springboot_03_thymeleaf.dao.ProductDao;
import com.yiwobao.springboot_03_thymeleaf.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productMapper;


    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public void deleteByProduct(String pname) {
        productMapper.deleteByProduct(pname);
    }

    @Override
    public void updateByProduct(Product product) {
        productMapper.updateByProduct(product);
    }

}
