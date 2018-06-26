package com.github.guolll.springboot.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Mr.L on 2018/4/16 0016.
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("数据源为{}", DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }

}
