package com.xxl.springboot.integration.test;

import com.xxl.springboot.integration.mail.SpringBootIntegrationMailApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @author xxl
 * @date 2025/2/23 18:48
 */
@SpringBootTest(classes = SpringBootIntegrationMailApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMail {
    @Resource
    private JavaMailSender javaMailSender;                    // 注入JavaMailSender对象

    @Test
    public void testSendMail() {
        SimpleMailMessage message = new SimpleMailMessage();    // 要发送的消息内容
        message.setFrom("508686616@qq.com");                // 发送者
        message.setTo("luckily126163@126.com");                // 接收者
        message.setSubject("测试邮件");             // 邮件主题
        message.setText("好好学习，天天向上。");     // 邮件内容
        this.javaMailSender.send(message);        // 发送邮件
    }
}
