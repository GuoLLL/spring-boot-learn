package com.github.guolll.springboot.mybatis;

import lombok.extern.slf4j.Slf4j;

/**
 * ContextHolder, 用于保存当前线程使用的数据源名
 */
@Slf4j
public class DataSourceContextHolder {

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = DataSourceType.testDs.toString();

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dbType
     */
    public static void setDB(String dbType) {
        log.info("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源
     *
     * @return String
     */
    public static String getDB() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源
     */
    public static void clearDB() {
        contextHolder.remove();
    }


}
