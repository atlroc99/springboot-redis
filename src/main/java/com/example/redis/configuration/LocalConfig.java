package com.example.redis.configuration;

import com.example.redis.service.StudentService;
import com.example.redis.service.StudentServiceH2Impl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("default")
public class LocalConfig {

    @ConfigurationProperties("spring.datasource.h2")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("h2")
    public DataSource h2DataSource(DataSourceProperties properties) {
        System.out.println("H2 Datasource created");
        return properties.initializeDataSourceBuilder().build();
    }

    @Qualifier("h2")
    @Bean
    public StudentService h2StudentService() {
        return new StudentServiceH2Impl();
    }
}
