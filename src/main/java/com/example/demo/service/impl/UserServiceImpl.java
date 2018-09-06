package com.example.demo.service.impl;

import com.example.demo.dao.LeUserMapper;
import com.example.demo.db1.bean.LeUser;
import com.example.demo.db1.bean.LeUserExample;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 17:22
 * 描述：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LeUserMapper leUserMapper;

    @Override
    public List<LeUser> getUserList() {
        LeUser c09b1c77f07e4359b9090bb1cc047ef5 = leUserMapper.selectByPrimaryKey("c09b1c77f07e4359b9090bb1cc047ef5");
        System.out.println(c09b1c77f07e4359b9090bb1cc047ef5);
        return null;
    }
}
