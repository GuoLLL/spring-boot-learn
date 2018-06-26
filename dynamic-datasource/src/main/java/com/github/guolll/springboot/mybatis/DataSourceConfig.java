package com.github.guolll.springboot.mybatis;

import com.google.common.collect.Maps;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by Mr.L on 2018/4/16 0016.
 */
@Configuration
public class DataSourceConfig {


    @Bean(name = "testDs")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2Ds")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return
     */
    @Bean(name = "dynamicDS")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(testDataSource());

        // 配置多数据源
        Map<Object, Object> dsMap = Maps.newHashMap();
        dsMap.put(DataSourceType.test2Ds.toString(), test2DataSource());
        dsMap.put(DataSourceType.testDs.toString(), testDataSource());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
