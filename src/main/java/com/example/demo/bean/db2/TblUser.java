package com.example.demo.bean.db2;

import lombok.Data;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
/**
 * 
 */
@Data
@ApiModel(description = "")
public class TblUser {
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;
}