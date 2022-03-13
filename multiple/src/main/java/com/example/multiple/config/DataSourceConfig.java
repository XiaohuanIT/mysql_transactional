package com.example.multiple.config;

import com.example.multiple.config.datasource.DynamicDataSource;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.d1.url}")
    private String url1;

    @Value("${spring.datasource.d1.username}")
    private String userName1;

    @Value("${spring.datasource.d1.password}")
    private String password1;

    @Value("${spring.datasource.d2.url}")
    private String url2;

    @Value("${spring.datasource.d2.username}")
    private String userName2;

    @Value("${spring.datasource.d2.password}")
    private String password2;


    /**
     * @return
     */
    @Bean(name = "datasourceD1")
    public DataSource getDataSourceD1() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url1);
        dataSource.setUsername(userName1);
        dataSource.setPassword(password1);
        log.info("datasourceD1 dataSource.getUrl(): {}", dataSource.getJdbcUrl());
        return dataSource;
    }

    /**
     * @return
     */
    @Bean(name = "datasourceD2")
    public DataSource getDataSourceD2() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url2);
        dataSource.setUsername(userName2);
        dataSource.setPassword(password2);
        log.info("getDataSourceD2 dataSource.getUrl(): {}", dataSource.getJdbcUrl());
        return dataSource;
    }

    /**
     * 动态数据源
     *
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(getDataSourceD1());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put(DynamicDataSource.DS_D1, getDataSourceD1());
        dsMap.put(DynamicDataSource.DS_D2, getDataSourceD2());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
}
