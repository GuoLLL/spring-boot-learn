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
@MapperScan(basePackages = {"com.github.guolll.springboot.mapper.test2"}, sqlSessionFactoryRef = "sqlSessionFactoryTest2")
public class DbTest2Config {

    @Autowired
    @Qualifier("test2Ds")
    private DataSource test2Db;

    private static final String MAPPER_LOCATION = "classpath:mybatis/mapper/test2/*.xml";

    @Bean
    public SqlSessionFactory sqlSessionFactoryTest2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(test2Db);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTest2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTest2()); // 使用上面配置的Factory
        return template;
    }
}
