package com.example.multiple.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 */
@Slf4j
@Component
@Aspect
public class DynamicDataSourceAspect {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * @param point
     */
    @Before("execution(* com.example.multiple.mapper.d2.*.*(..))")
    public void beforeSwitchDS(JoinPoint point) {
        DataSourceContextHolder.setDB(DynamicDataSource.DS_D2);
        sqlSessionFactory.getConfiguration().setUseColumnLabel(Boolean.FALSE);
    }

    /**
     * @param point
     */
    @After("execution(* com.example.multiple.mapper.*.*.*(..))")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDB();
        sqlSessionFactory.getConfiguration().setUseColumnLabel(Boolean.TRUE);
    }
}
