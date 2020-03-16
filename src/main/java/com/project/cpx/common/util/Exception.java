package com.project.cpx.common.util;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:56
 * @Description:
 */
public class Exception extends RuntimeException {

    private String msg;
    private String code;

    public Exception() {
    }

    public Exception(String msg) {
        super(msg);
        this.msg = msg;
    }

    public Exception(String code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public Exception(String msg, String code, Throwable e) {
        super(msg, e);
        this.code = code;
        this.msg = msg;
    }

    public Exception(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public Exception(Throwable e) {
        super(e);
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
