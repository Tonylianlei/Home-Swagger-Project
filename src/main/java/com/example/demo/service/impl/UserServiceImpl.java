package com.example.demo.service.impl;

import com.example.demo.bean.db1.LeUser;
import com.example.demo.bean.db2.TblUser;
import com.example.demo.bean.db2.TblUserExample;
import com.example.demo.bean.dto.UserInfoDTO;
import com.example.demo.dao.db1.LeUserMapper;
import com.example.demo.dao.db2.TblUserMapper;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
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
    private LeUserMapper leUserMapper;
    @Autowired
    private EmailService emailService;

    /**
     *开 发 者：连磊
     *开发时间：2018/9/17 14:47
     *方 法 名：getUserYById
     *传入参数：[id]
     *返 回 值：java.util.List<com.example.demo.bean.db1.LeUser>
     *描    述：根据当前id，查询详情
     **/
    @Override
    public LeUser getUserYById(String id) {
        emailService.sendEmail(null , null , null);
        return leUserMapper.selectByPrimaryKey(id);
    }

    /**
     *开 发 者：连磊
     *开发时间：2018/9/18 14:23
     *方 法 名：registerUser
     *传入参数：[userInfoDTO]
     *返 回 值：java.lang.String
     *描    述：用户注册
     **/
    @Override
    public String registerUser(UserInfoDTO userInfoDTO) {
        LeUser leUser = new LeUser();
        return null;
    }
}
