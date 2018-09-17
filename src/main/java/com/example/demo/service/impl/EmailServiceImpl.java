package com.example.demo.service.impl;

import com.example.demo.configpool.email.EmailPool;
import com.example.demo.service.EmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 15:46
 * 描述：
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private EmailPool emailPool;

    @Override
    public Boolean sendEmail(String sendToUserName, String sendToUserEmail, String config) {
        sendToUserEmail = "3102365594@qq.com";
        sendToUserName = "连";
        config = "0";
        return emailPool.sendEmail(sendToUserName , sendToUserEmail , config);
    }
}
