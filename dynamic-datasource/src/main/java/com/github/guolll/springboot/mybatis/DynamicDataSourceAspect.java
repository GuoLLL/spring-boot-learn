package com.github.guolll.springboot.mybatis;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Mr.L on 2017/12/25 0025.
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint joinPoint) {
        //获得当前访问的class
        Class<?> aClass = joinPoint.getTarget().getClass();
        //获得当前访问的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到方法的参数类型
        /**
         * 注意：方法参数必须用大类型，否则找不到对应方法
         * 如：用Integer,Long,Boolean,不能用int,long,boolean
         */
        Object[] args = joinPoint.getArgs();
        Class[] argClass = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argClass[i] = args[i].getClass();
        }
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            Method method = aClass.getMethod(methodName, argClass);
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                dataSource = annotation.value().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("@annotation(DS)")
    public void afterSwitchDS() {
        DataSourceContextHolder.clearDB();
    }
}
