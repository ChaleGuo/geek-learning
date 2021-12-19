package com.example.exercise.week7.mydds.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String ds = DynamicDataSourceContextHolder.getContextKey();
        log.info("选择数据源, ds={}",ds);
        return ds;
    }
}
