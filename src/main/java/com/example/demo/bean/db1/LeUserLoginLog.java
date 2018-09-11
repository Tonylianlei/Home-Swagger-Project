package com.example.demo.bean.db1;

import java.util.Date;
import lombok.Data;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
/**
 * 登录日志
 */
@Data
@ApiModel(description = "登录日志")
public class LeUserLoginLog {
    @ApiModelProperty(value = "主id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "登录地址")
    private String loginAddress;
}