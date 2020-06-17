package com.joe.springbootmedium.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//註冊攔截器
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        addPathPatterns攔截指定路徑
//        excludePathPatterns排除攔截指定路徑
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/")
                .addPathPatterns("/books/**")
                .excludePathPatterns("s");

    }
}
