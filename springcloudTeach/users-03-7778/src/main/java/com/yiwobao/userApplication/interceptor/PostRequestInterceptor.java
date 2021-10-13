/*
package com.yiwobao.userApplication.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;

//@Configuration
@Component
public class PostRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

        System.out.println("我进来了 拦截器...");
        //if ("post".equalsIgnoreCase(template.method()) && template.body() == null) {
            String query = template.queryLine();
            template.queries(new HashMap<>());
            if (StringUtils.hasText(query) && query.startsWith("?")) {
                template.body(query.substring(1));
            }
            template.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
      //  }
    }
}*/
