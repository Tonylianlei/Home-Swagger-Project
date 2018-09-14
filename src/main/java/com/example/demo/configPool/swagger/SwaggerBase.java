package com.example.demo.configPool.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建人:连磊
 * 日期: 2018/9/12. 14:56
 * 描述：嵌入swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerBase {

    /**
     *开 发 者：连磊
     *开发时间：2018/9/12 14:58
     *方 法 名：apiInfo
     *传入参数：[]
     *返 回 值：springfox.documentation.service.ApiInfo
     *描    述：声明Swagger功能，版本等基础信息
     **/
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("项目嵌入Swagger功能")
                .contact(new Contact("连磊" , "http://localhost:8080" , "18210470058@163.com"))
                .version("1.0")
                .description("功能整理")
                .build()
                ;
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //.groupName("User：用户信息")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

}
