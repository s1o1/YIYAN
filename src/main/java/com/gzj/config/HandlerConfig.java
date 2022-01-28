package com.gzj.config;

import com.gzj.handler.PerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class HandlerConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/").excludePathPatterns("index.html")
                .excludePathPatterns("/img")
                .excludePathPatterns("/user_login")
                .excludePathPatterns("/login").excludePathPatterns("login.html");
    }
}
