package com.project.cpx.common.util;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:57
 * @Description:
 */
public enum ErrorEnum {

    PARAM("2000","验证参数[%s]异常"),
    USER_IS_EXIST("2001","该用户已存在"),
    CONFIG_IS_EXIST("2002","该值已存在"),
    USER_OR_PASSWORD_IS_NOT_RIGHT("2003","用户名或密码错误！"),
    NOT_LOGIN("2004","未登陆"),
    LONG_TIME_NOT_LOGIN("2005","长时间未登陆，请重新登陆！"),;

    private String code;
    private String msg;

    ErrorEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
