package com.example.multiple.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 *
 */
@Slf4j
public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "d1";

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源名
     *
     * @param dbType
     */
    public static void setDB(String dbType) {
        log.info("setDB->dbType = [{}]", dbType);
        CONTEXT_HOLDER.set(dbType);
    }

    /**
     * 获取数据源名
     *
     * @return
     */
    public static String getDB() {
        return ObjectUtils.isEmpty(CONTEXT_HOLDER.get()) ? DEFAULT_DS : CONTEXT_HOLDER.get();

    }

    /**
     * 清除数据源名
     */
    public static void clearDB() {
        CONTEXT_HOLDER.remove();
    }
}
