package com.glodon.tcpcopy.bo.commom;

import java.io.Serializable;

/**
 * Created by zhangxin on 2016/11/11.
 */
public class JsonResult {
    private boolean success;
    private String message;
    private Serializable data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }
}
