package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 17:20
 * 描述：
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

}
