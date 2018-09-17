package com.example.demo.utils.exceptionutil;

import com.example.demo.utils.resultutil.ResultCodeEnum;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 10:44
 * 描述：自定义异常处理
 */
public class BusinessException extends RuntimeException {

    private String code;


    public BusinessException(String message , String code){
        super(message);
        this.code = code;
    }

    public BusinessException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public BusinessException(Throwable throwable){
        super(throwable);
    }

    public BusinessException(String message , String code,Throwable throwable){
        super(message , throwable);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
