package com.xxl.springboot.integration.jpa;

import com.xxl.springboot.integration.jpa.po.Dept;
import com.xxl.springboot.integration.jpa.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author xxl
 * @date 2025/1/15 0:15
 */
@SpringBootTest(classes = SpringbootIntegrationJpaApplication.class)		// 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)							// 使用Junit进行测试
@WebAppConfiguration											// 进行Web应用配置
public class TestDeptService {
    @Autowired
    private IDeptService deptService ; 							// 注入业务接口对象
    @Test
    public void testList() {
        List<Dept> allDepts = this.deptService.list() ;
        for (Dept dept : allDepts) {
            System.out.println("部门编号：" + dept.getDeptno() + "、部门名称：" + dept.getDname());
        }
    }
}