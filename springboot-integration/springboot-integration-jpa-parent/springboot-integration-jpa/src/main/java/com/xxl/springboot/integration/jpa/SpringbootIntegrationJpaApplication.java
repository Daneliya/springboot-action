package com.xxl.springboot.integration.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.xxl.springboot.integration.jpa.dao")
public class SpringbootIntegrationJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegrationJpaApplication.class, args);
    }

}
