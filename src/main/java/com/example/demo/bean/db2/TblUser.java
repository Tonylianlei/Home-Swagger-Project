package com.example.demo.bean.db2;

import lombok.Data;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
/**
 * 用户
 */
@Data
@ApiModel(description = "用户")
public class TblUser {
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;
}