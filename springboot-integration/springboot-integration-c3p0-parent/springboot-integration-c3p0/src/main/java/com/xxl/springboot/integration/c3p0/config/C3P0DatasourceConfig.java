package com.xxl.springboot.integration.c3p0.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * C3P0数据源连接池配置类
 *
 * @author xxl
 * @date 2025/1/13 0:24
 */
@Configuration
public class C3P0DatasourceConfig {
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "c3p0")    // 定义资源导入前导标记
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(
                com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}