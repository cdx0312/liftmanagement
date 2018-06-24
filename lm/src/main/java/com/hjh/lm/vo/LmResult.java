package com.hjh.lm.vo;

/**
 * 通用返回数据
 */
public class LmResult {
    private String code;

    private String message;

    private Object data;

    public LmResult() {
    }

    public LmResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public LmResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
