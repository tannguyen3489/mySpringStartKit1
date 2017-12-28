package com.memorynotfound.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    @Bean
//    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
////                .build().apiInfo(apiInfo());
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.memorynotfound.spring.security.web.rest"))
//                .paths(PathSelectors.ant("/api-rest/*"))
//                .build().apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "My REST API",
//                "Some custom description of API.",
//                "API TOS",
//                "Terms of service",
//                new Contact("John Doe", "www.example.com", "myeaddress@company.com"),
//                "License of API", "API license URL", Collections.emptyList());
//    }


    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.memorynotfound.spring.security.web.rest"))
                .paths(regex("/api-rest/users.*"))
                .build().apiInfo(metaData());

    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                "Tan Nguyen",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}