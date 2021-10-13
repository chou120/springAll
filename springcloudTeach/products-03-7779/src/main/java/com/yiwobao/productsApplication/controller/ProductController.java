package com.yiwobao.productsApplication.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yiwobao.productsApplication.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//`在springcloud中服务间调用方式主要是使用 http restful方式进行服务间调用`  所以得使用@RestController 返回json数据
@RestController
@Slf4j
//配置类级别的服务降级
@DefaultProperties(defaultFallback = "testFallbackMethod")
public class ProductController {
    /**
     * 测试类级别的服务降级
     */
    @GetMapping("/product/testClassHystrix")
    @HystrixCommand
    public  String testClassHystrix(Integer id){
        if(id< 0){
            throw new RuntimeException("传入参数-----Class----不合法");
        }
        return "传入参数------class-------合法,值为:"+id;
    }

    /**
     * 用来测试 熔断
      * @return
     */
    @GetMapping("/product/testHystrix")
    //@HystrixCommand(fallbackMethod = "testFallbackMethod")
    @HystrixCommand
    public  String   testHystrix(Integer id){
        if(id< 0){
            throw new RuntimeException("传入参数不合法");
        }
        return "传入参数合法,值为:"+id;
    }

    public  String testFallbackMethod(){
        return "当前服务不可用,这里是做类级别的服务降级";
    }


    @GetMapping("/product/showInfo")
    public  String showInfo(){
        log.info("进入商品服务,展示所有商品~");
        return "进入商品服务,展示所有商品~";
    }

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/product/findAll")
    public Map<String,Object> findAll(){
        log.info("模拟从数据库中查询:商品服务查询所有调用成功");
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("msg", "用户服务的端口号为:"+port+","+Arrays.asList(new String[][]{{"张三", "123456"},{"李四","123456"},{"王五","123456"},{"赵括","123456"}}));
        map.put("status",true);
        return map;
    }

    @GetMapping("/product/findByCondition")
    public Map<String,Object> findByCondition(String productId){

        try {
            //用来测试openFeign超时
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("status",true);
        map.put("端口号为:",port);
        map.put("productId","这里是根据productId查询出来的数据,从用户服务传递过来的查询条件为:"+productId);
        return map;
    }



    @PostMapping("/product/save")
    public Map<String,Object> save(String name){
        log.info("当前接收商品名称:[{}]",name);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("msg","商品服务查询商品信息调用成功,当前服务端口: "+port);
        map.put("status",true);
        map.put("name","这里是根据name查询出来的数据,从用户服务传递过来的查询条件为:"+name);
        return map;
    }


    @PostMapping("/product/saveProduct")
    public Map<String,Object> saveProduct(@RequestBody Product product){
        log.info("当前接收商品名称:[{}]",product);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("msg","商品服务查询商品信息调用成功,当前服务端口: "+port);
        map.put("status",true);
        map.put("product",product);
        return map;
    }


}
