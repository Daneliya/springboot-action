package com.xxl.springboot.integration.test;

import com.xxl.springboot.integration.actuator.SpringBootIntegrationActuatorApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xxl
 * @date 2025/2/23 18:48
 */
@SpringBootTest(classes = SpringBootIntegrationActuatorApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class Test {

}
