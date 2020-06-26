package com.demo.springboot.helloworld.common.utils;
/*编写人：
编写功能：返回的通用类
编写时间：6月15-16日*/
public class ResultJson {
    private int code = 1;
    private Object data = null;
    private String message = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
