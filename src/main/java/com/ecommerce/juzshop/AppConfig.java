package com.ecommerce.juzshop;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration

public class AppConfig {
    DriverManagerDataSource db;

    @Bean
    public DataSource getDataSource() {
        db = new DriverManagerDataSource();

        db.setDriverClassName("org.postgresql.Driver");
        db.setUrl("jdbc:postgresql://localhost:5432/juzshop");
        db.setUsername("system");
        db.setPassword("system");

        return db;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DriverManagerDataSource db) {
        if (db == null) {
            System.out.println("Null!!!!!!!!!!!!!!!!!!!!!!!! /n");
        }
        return new NamedParameterJdbcTemplate(db);
    }

}