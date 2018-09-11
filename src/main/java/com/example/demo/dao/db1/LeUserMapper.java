package com.example.demo.dao.db1;

import com.example.demo.bean.db1.LeUser;
import com.example.demo.bean.db1.LeUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeUserMapper {
    long countByExample(LeUserExample example);

    int deleteByExample(LeUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(LeUser record);

    int insertSelective(LeUser record);

    List<LeUser> selectByExample(LeUserExample example);

    LeUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LeUser record, @Param("example") LeUserExample example);

    int updateByExample(@Param("record") LeUser record, @Param("example") LeUserExample example);

    int updateByPrimaryKeySelective(LeUser record);

    int updateByPrimaryKey(LeUser record);
}