package com.bifengle.demo.common.bean;

import lombok.Data;

@Data
public class Return<T> {

    private boolean success;

    private T data;

    private int errorCode;
    
    private String errorMsg;

    public Return() {
    }

    public Return(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Return(boolean success, int errorCode, String errorMsg) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static <T> Return<T> success(T data) {
        return new Return<T>(true, data);
    }

    public static Return<String> fail(int errorCode, String errorMsg) {
        Return<String> response = new Return<String>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setErrorMsg(errorMsg);
        response.setData("");
        return response;
    }
}
