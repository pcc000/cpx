package com.project.cpx.common.util;

import com.project.cpx.entity.query.BaseQuery;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:46
 * @Description:
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 2994494589314183496L;
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3-9][0-9]{9}$");
    private boolean success;
    private T data;
    private String errCode;
    private String errMsg;

    private BaseQuery query;

    public Response() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static <T> Response ok(T data) {
        Response<T> result = new Response();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static <T> Response ok(T data, BaseQuery query){
        Response<T> result = new Response<>();
        result.setData(data);
        result.setQuery(query);
        result.setSuccess(true);
        return result;
    }

    public static <T> Response ok() {
        Response<T> result = new Response();
        result.setData(null);
        result.setSuccess(true);
        return result;
    }

    public static <T> Response<T> fail(String errCode, String errMsg) {
        Response result = new Response();
        result.setSuccess(false);
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> Response<T> fail(ErrorEnum errorEnum) {
        return fail(errorEnum.getCode(), errorEnum.getMsg());
    }

    public BaseQuery getQuery() {
        return query;
    }

    public void setQuery(BaseQuery query) {
        this.query = query;
    }
}
