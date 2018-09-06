package com.example.demo.db1.bean;

import java.util.Date;
import lombok.Data;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
/**
 * 用户
 */
@Data
@ApiModel(description = "用户")
public class LeUser {
    @ApiModelProperty(value = "主id")
    private String id;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "中文名称")
    private String cnName;

    @ApiModelProperty(value = "英文名称")
    private String enName;

    @ApiModelProperty(value = "手机号")
    private String tel;

    @ApiModelProperty(value = "身份证")
    private String identityId;

    @ApiModelProperty(value = "身份证加密")
    private String identityEncrypt;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "性别：0：男，1：女")
    private Integer sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "出生年月日")
    private Date birthday;

    @ApiModelProperty(value = "省")
    private Integer province;

    @ApiModelProperty(value = "市")
    private Integer city;

    @ApiModelProperty(value = "区")
    private Integer area;

    @ApiModelProperty(value = "所在地址")
    private String address;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "创建人id")
    private String createId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人id")
    private String updateId;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "状态：1正常，2删除。。。")
    private Integer state;
}