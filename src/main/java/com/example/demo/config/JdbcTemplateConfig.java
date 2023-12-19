package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {
    // 작성방식은 여러가지가 있다.
    // 1. @Bean 어노테이션 : 메소드에 달 수 있음 / 객체의 코드를 내가 변경할 수 없을 때 사용(통상 라이브러리의 객체일 때)
    // 2. @Component 어노테이션 : 클래스에 달 수 있음 / 객체의 코드를 내가 변경할 수 있을 때 사용

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
