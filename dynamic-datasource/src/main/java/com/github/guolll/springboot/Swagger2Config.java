package com.github.guolll.springboot;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Mr.L on 2017/12/19 0019.
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {


    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo.DEFAULT)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.guolll.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.git.guolll.springboot.timesheet.controller.rest"))
//                .paths(PathSelectors.any())
//                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot 中使用Swagger2构建 Restful API")
                .contact("GitHub.GuoLLL")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .licenseUrl("http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0.0").build();
    }
}
