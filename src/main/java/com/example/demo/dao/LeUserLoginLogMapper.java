package com.example.demo.dao;

import com.example.demo.db1.bean.LeUserLoginLog;
import com.example.demo.db1.bean.LeUserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeUserLoginLogMapper {
    long countByExample(LeUserLoginLogExample example);

    int deleteByExample(LeUserLoginLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(LeUserLoginLog record);

    int insertSelective(LeUserLoginLog record);

    List<LeUserLoginLog> selectByExample(LeUserLoginLogExample example);

    LeUserLoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LeUserLoginLog record, @Param("example") LeUserLoginLogExample example);

    int updateByExample(@Param("record") LeUserLoginLog record, @Param("example") LeUserLoginLogExample example);

    int updateByPrimaryKeySelective(LeUserLoginLog record);

    int updateByPrimaryKey(LeUserLoginLog record);
}