package com.xxl.springboot.integration.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication   // 启动SpringBoot程序，而后自带子包扫描
@EnableScheduling    // 启用调度
public class SpringBootIntegrationSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationSchedulerApplication.class, args);
    }

}
