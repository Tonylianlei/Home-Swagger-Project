package com.example.demo.service.impl;

import com.example.demo.bean.db2.TblUser;
import com.example.demo.bean.db2.TblUserExample;
import com.example.demo.dao.db2.TblUserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 17:22
 * 描述：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TblUserMapper tblUserMapper;

    @Override
    @Transactional(value = "db2TransactionManager" , rollbackFor = Exception.class)
    public void getUserdb2() {
        TblUserExample tblUserExample = new TblUserExample();
        tblUserExample.createCriteria();
        List<TblUser> tblUsers = tblUserMapper.selectByExample(tblUserExample);
        System.out.println(tblUsers);
    }
}
