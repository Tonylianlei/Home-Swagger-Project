package com.example.demo.service;

import com.example.demo.bean.db1.LeUser;
import com.example.demo.bean.dto.UserInfoDTO;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 17:21
 * 描述：
 */
public interface UserService {

    LeUser getUserYById(String id);

    /**
     *开 发 者：连磊
     *开发时间：2018/9/18 14:21
     *描    述：注册用户
     **/
    String registerUser(UserInfoDTO user);
}
