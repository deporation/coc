package com.tisu.goods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author deporation
 * @date 2021/1/1 21:40
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tisu.goods.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("coc网络聊天室goodsclient")
                        .description("coc网络聊天室goodsclient")
                        .version("test")
                        .contact(new Contact("deporation", "www.github.com/deporation", "deporation1@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("http://127.0.0.1:8762/openapi/spec.json")
                        .build());
    }
}
