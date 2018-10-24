package com.example.demo.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 创建人:连磊
 * 日期: 2018/9/18. 14:26
 * 描述：
 */
@Data
@ApiModel(description = "用户 Dto")
public class UserInfoDTO {

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

}
