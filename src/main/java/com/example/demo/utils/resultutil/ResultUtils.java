package com.example.demo.utils.resultutil;

import org.springframework.util.StringUtils;

/**
 * 创建人:连磊
 * 日期: 2018/9/14. 17:33
 * 描述：返回参数工具类
 */
public class ResultUtils<T> {

    /**
     * 返回信息,并设置默认值
     */
    private String message = ResultCodeEnum.REQUEST_SUCCESS.getMessage();

    /**
     * 返回code，并设置默认值
     */
    private String code = ResultCodeEnum.REQUEST_SUCCESS.getCode();

    /**
     * 返回具体信息
     */
    private T obj = null;

    private static ResultUtils resultUtils = null;

    public static ResultUtils createResult(){
        if (resultUtils == null){
            synchronized (ResultUtils.class){
                if (null == resultUtils){
                    resultUtils = new ResultUtils();
                }
            }
        }
        return resultUtils;
    }

    public ResultUtils setResultMessage(String message, String code, T obj){
        if (StringUtils.isEmpty(message)){
            message = this.message;
        }
        if (StringUtils.isEmpty(code)){
            code = this.code;
        }
        createResult().setMes(message).setCodeValue(code).setObjValue(obj);
        return resultUtils;
    }

    public ResultUtils setResultMessage(String message, String code){
        if (StringUtils.isEmpty(message)){
            message = this.message;
        }
        if (StringUtils.isEmpty(code)){
            code = this.code;
        }
        createResult().setMes(message).setCodeValue(code);
        return resultUtils;
    }

    public ResultUtils setMes(String message){
        resultUtils.setMessage(message);
        return resultUtils;
    }

    public ResultUtils setCodeValue(String code){
        resultUtils.setCode(code);
        return resultUtils;
    }

    public ResultUtils setObjValue(T object){
        resultUtils.setObj(object);
        return resultUtils;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setObj(T obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public T getObj() {
        return obj;
    }
}
