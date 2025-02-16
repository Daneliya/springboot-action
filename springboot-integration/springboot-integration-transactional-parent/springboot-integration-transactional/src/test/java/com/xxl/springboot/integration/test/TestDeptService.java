package com.xxl.springboot.integration.test;

import com.xxl.springboot.integration.transactional.SpringBootIntegrationTransactionalApplication;
import com.xxl.springboot.integration.transactional.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xxl
 * @date 2025/2/11 0:03
 */
@SpringBootTest(classes = SpringBootIntegrationTransactionalApplication.class)        // 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)                            // 使用Junit进行测试
@WebAppConfiguration                                            // 进行Web应用配置
public class TestDeptService {

    @Autowired
    private IDeptService deptService;                            // 注入业务接口对象

    @Test
    public void testAdd() {
        this.deptService.addDept("科室1");
    }
}

