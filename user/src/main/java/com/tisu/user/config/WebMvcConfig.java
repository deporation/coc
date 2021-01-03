package com.tisu.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author deporation
 * @date 2021/1/3 3:41
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //MediaType.APPLICATION_JSON 设置的是application/json ，想要设置其他的可以到MediaType类里面去找相关的常量哦
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}
