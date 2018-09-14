package com.example.demo.controller;

import com.example.demo.bean.db2.TblUser;
import com.example.demo.service.UserService;
import com.example.demo.utils.resultutil.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 17:20
 * 描述：
 */
@RestController
@Api(description = "用户信息" )
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/setUser" , method = RequestMethod.POST)
    @ApiOperation(value = "获取学生")
    public ResultUtils getUser(@RequestBody TblUser tblUser){
        userService.getUserdb2();
        return ResultUtils.setResult();
    }

}
