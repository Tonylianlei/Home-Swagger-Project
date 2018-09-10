package com.example.demo.service.impl;

import com.example.demo.dao.LeUserLoginLogMapper;
import com.example.demo.dao.LeUserMapper;
import com.example.demo.db1.bean.LeUser;
import com.example.demo.db1.bean.LeUserExample;
import com.example.demo.db1.bean.LeUserLoginLog;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private LeUserLoginLogMapper leUserLoginLogMapper;

    @Override
    @Transactional("db1TransactionManager")
    public List<LeUser> getUserList() {
        LeUser user = new LeUser();
        user.setId("sdfsdfsdfsdafag");
       leUserMapper.insert(user);
        LeUserLoginLog leUserLoginLog = new LeUserLoginLog();
       leUserLoginLogMapper.insert(leUserLoginLog);
        return new ArrayList<>();
    }
}
