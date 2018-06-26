package com.github.guolll.springboot.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by Mr.L on 2018/4/16 0016.
 */
@Configuration
@MapperScan(basePackages = {"com.github.guolll.springboot.mapper.test"}, sqlSessionFactoryRef = "sqlSessionFactoryTest")
public class DbTestConfig {

    @Autowired
    @Qualifier("testDs")
    private DataSource testDb;

    private static final String MAPPER_LOCATION = "classpath:mybatis/mapper/test/*.xml";

    @Bean
    public SqlSessionFactory sqlSessionFactoryTest() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(testDb);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTest() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTest()); // 使用上面配置的Factory
        return template;
    }
}
