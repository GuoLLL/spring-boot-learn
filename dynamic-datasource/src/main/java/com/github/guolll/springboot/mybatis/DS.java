package com.github.guolll.springboot.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注释@DS用于在编码时指定方法使用哪个数据源
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DS {
    DataSourceType value() default DataSourceType.testDs;
}
