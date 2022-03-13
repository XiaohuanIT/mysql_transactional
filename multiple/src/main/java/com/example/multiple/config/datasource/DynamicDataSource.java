package com.example.multiple.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final String DS_D1 = "d1";

    public static final String DS_D2 = "d2";


    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源 dynamic dataSource is: {}", DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
