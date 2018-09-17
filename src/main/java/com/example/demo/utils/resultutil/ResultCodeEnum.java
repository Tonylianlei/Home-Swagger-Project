package com.example.demo.utils.resultutil;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 9:43
 * 描述：
 */
public enum ResultCodeEnum {

    REQUEST_SUCCESS("0000","成功"),
    REQUEST_UNKNOWN_ERROR("1000","未知错误"),
    ;
    private String code;
    private String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
            return message;
        }

}
