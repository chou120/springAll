package com.yiwobao.springboot_07_redis_project.config;

import com.yiwobao.springboot_07_redis_project.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    //定义拦截器拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")//需要拦截的路径
                .excludePathPatterns("/doLogin")//排除/doLogin路径
                .excludePathPatterns("/");//排除/路径
    }


}
