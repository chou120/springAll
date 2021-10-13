package com.yiwobao.springboot_05_swagger2.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2 //开启swagger
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        /**
         * 这个 Docket类，是Springfox 框架的API配置机制实现的builder类。
         *
         * 我们通过@Configuration标记此类为配置类，会在SpringBoot项目启动的时候加载，
         * 实际上我们已经完成了对Swagger的配置，Swagger会自动扫描我们配置的cn.com.wenyi.controller包下的接口自动生成接口文档。
         *
         */
        return new Docket(DocumentationType.SWAGGER_2)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // (第一种方式)扫描所有有注解的api，用这种方式更灵活
                //.apis( RequestHandlerSelectors.withMethodAnnotation( ApiOperation.class ) )
                //(第二种方式)扫描指定包中的swagger注解
                .apis(RequestHandlerSelectors.basePackage("com.yiwobao.springboot_05_swagger2.controller"))
                // (第三种方式)扫描所有
                //.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                //相关描述
                .description("更多Spring Boot相关文章请关注：http://www.yiwobaoit.com/")
                //这里配置的是服务网站(比如说我可以通过点击此网站得到相关的swagger技术信息等等，这里我随便配置了一个公司网址)
                .termsOfServiceUrl("http://www.yiwobaoit.com/")
                // 作者信息
                .contact("sanye")
                //版本号
                .version("1.0")
                .build();
    }


}