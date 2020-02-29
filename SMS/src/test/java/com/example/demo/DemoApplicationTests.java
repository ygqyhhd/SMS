package com.example.demo;

import com.example.demo.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;

import javax.mail.MessagingException;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    MailService mailService;
    @Test
    public void testMail() throws  Exception {
        String to = "2210649752@qq.com";
        String subject ="奥特曼";
        String content="转账！！！";

        try {
            mailService.sendSimpleMail(to, subject, content);
            System.out.println("成功了");

        } catch (MailException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }
    @Test
    public void test2() {
        String to = "2210649752@qq.com";
        String subject = "今晚要加班，不用等我了";
        String rscId = "img110";
        String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
        // 此处为linux系统路径
        String imgPath = "C:/Users/ASUS/Desktop/2.jpg";
        try {
            mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }
    @Test
    public void test() {
        String to = "2210649752@qq.com";
        String subject = "猜猜我今天买了啥";
        String content = "<html><head></head><body><h3>哈哈，什么都没有</h3></body></html>";
        try {
            mailService.sendHtmlMail(to, subject, content);
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }
    @Test
    public void test3() {
        String to = "2210649752@qq.com";
        String subject = "这是一个有附件的邮件，记得接受文件";
        String content = "嗯哼？自己看附件";
        String imgPath = "C:/Users/ASUS/Desktop/1.gif";
        try {
            mailService.sendAttachmentsMail(to, subject, content, imgPath);
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }


}
