package com.example.demo.utils.resultutil;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 9:43
 * 描述：
 */
public class ResultEnum {

    public enum ResultMessage{
        REQUEST_SUCCESS("0","成功")
        ;
        private String code;
        private String message;

        ResultMessage(String code, String message) {
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

}
