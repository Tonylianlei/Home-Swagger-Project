package com.example.demo.controller;

import com.example.demo.db1.bean.LeUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 17:20
 * 描述：
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public void getUser(){
        List<LeUser> userList = userService.getUserList();
        System.out.println(userList.size());
    }

}
