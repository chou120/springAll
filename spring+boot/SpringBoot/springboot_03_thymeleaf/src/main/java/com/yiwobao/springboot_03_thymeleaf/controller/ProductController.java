package com.yiwobao.springboot_03_thymeleaf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiwobao.springboot_03_thymeleaf.pojo.Product;
import com.yiwobao.springboot_03_thymeleaf.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    /*@GetMapping("/showAll")
    public String  getAllProduct(Model model){
        List<Product> all = productService.getAll();
        model.addAttribute("list",all);
        return "showAll";
    }
*/
    //分页操作
    @GetMapping("/pageProduct")
    public String pageProduct(Model model,
                             @RequestParam(defaultValue="1")Integer pageNum,
                             @RequestParam(defaultValue="2")Integer pageSize) {

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        List<Product> list = productService.getAll();
        PageInfo<Product> pageInfo = new PageInfo<>(list);

        model.addAttribute("pageInfo",pageInfo);

        return "showAll";
    }
}