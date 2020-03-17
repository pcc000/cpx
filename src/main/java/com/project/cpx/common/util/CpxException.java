package com.project.cpx.common.util;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:56
 * @Description:
 */
public class CpxException extends RuntimeException {

    private String msg;
    private String code;

    public CpxException() {
    }

    public CpxException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CpxException(String code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CpxException(String msg, String code, Throwable e) {
        super(msg, e);
        this.code = code;
        this.msg = msg;
    }

    public CpxException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CpxException(Throwable e) {
        super(e);
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
