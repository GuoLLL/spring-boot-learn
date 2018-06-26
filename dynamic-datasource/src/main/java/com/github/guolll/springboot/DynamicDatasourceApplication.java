package com.github.guolll.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
public class DynamicDatasourceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceApplication.class, args);
        System.out.println("DynamicDatasourceApplication start success!!!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DynamicDatasourceApplication.class);
    }
}
