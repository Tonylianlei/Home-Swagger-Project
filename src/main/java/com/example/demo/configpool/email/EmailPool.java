package com.example.demo.configpool.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 15:39
 * 描述：配置动态邮件
 */
@Component
@ConfigurationProperties(prefix = "send-email")
public class EmailPool {

    private Map<String , Map<String , String>> mail;

    public Map<String, Map<String, String>> getMail() {
        return mail;
    }

    public void setMail(Map<String, Map<String, String>> mail) {
        this.mail = mail;
    }

    public Boolean sendEmail(String sendToUserName, String sendToUserEmail, String config){
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            Map<String, String> map = mail.get("mail-"+config);
            javaMailSender.setUsername(map.get("username").toString());
            javaMailSender.setPassword(map.get("password").toString());
            javaMailSender.setPort(25);
            javaMailSender.setHost(map.get("host").toString());
            javaMailSender.setDefaultEncoding(map.get("default-encoding").toString());

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(map.get("username").toString());
            simpleMailMessage.setTo(sendToUserEmail);
            simpleMailMessage.setSubject("sdfasdfsafsddfsfsfsdf");
            simpleMailMessage.setText("dfsafsdfsa是的发送到好地方科技安徽省");

            javaMailSender.send(simpleMailMessage);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
