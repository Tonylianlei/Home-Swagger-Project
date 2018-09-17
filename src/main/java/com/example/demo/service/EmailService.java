package com.example.demo.service;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 15:42
 * 描述：邮件发送
 */
public interface EmailService {

    Boolean sendEmail(String sendToUserName , String sendToUserEmail , String config);

}
