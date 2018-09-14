package com.example.demo.utils.resultutil;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;

/**
 * 创建人:连磊
 * 日期: 2018/9/14. 17:33
 * 描述：返回参数工具类
 */
@Data
public class ResultUtils<T> {

    //返回信息
    private String message = "";

    //返回Code
    private String code = "0";

    //返回对象
    private T obj = null;

    private static volatile ResultUtils resultUtils = null;

    public static ResultUtils setResult(){
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
        setResult().setMes(message).setCodeValue(code).setObjValue(obj);
        return resultUtils;
    }

    public ResultUtils setResultMessage(String message, String code){
        setResult().setMes(message).setCodeValue(code);
        return resultUtils;
    }

    public ResultUtils setResultMessage(String message , T obj){
        setResult().setMes(message).setObjValue(obj);
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
}
