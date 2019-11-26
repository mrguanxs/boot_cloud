package com.guan.filter;

/**
 * @author Mr.Guan
 * @since 2019/11/26
 */
public class Result {

    private int ret;
    private String message;
    private boolean success;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Result(int ret, String message, boolean success) {
        this.ret = ret;
        this.message = message;
        this.success = success;
    }

    public Result() {
    }
}
