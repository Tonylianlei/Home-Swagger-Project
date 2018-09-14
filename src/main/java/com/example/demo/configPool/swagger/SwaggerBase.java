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
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;


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
                //可用做分组标识，但是用了这个后不能使用离线功能
                //.groupName("User：用户信息")
                //是否加入自己默认的参数
                .globalOperationParameters(getParmeter())
                //加载默认配置
                .apiInfo(apiInfo())
                .select()
                //设置扫描的包（若分组可以指定到具体的包下）
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    /**
     *开 发 者：连磊
     *开发时间：2018/9/14 15:24
     *方 法 名：getParmeter
     *传入参数：[]
     *返 回 值：java.util.List<springfox.documentation.service.Parameter>
     *描    述：设置一个默认请求标识
     **/
    private List<Parameter> getParmeter(){
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        //设置一个默认的参数
        parameterBuilder.name("CurTime").description("当前用户的登录Token").defaultValue(String.valueOf(System.currentTimeMillis()))
                //标识出当前参数类型，和位置
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }

}
