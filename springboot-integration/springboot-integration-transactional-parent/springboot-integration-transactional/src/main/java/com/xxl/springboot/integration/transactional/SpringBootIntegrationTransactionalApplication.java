package com.xxl.springboot.integration.transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootIntegrationTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationTransactionalApplication.class, args);
    }

}
