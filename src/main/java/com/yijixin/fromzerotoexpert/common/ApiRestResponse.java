package com.yijixin.fromzerotoexpert.common;

import com.yijixin.fromzerotoexpert.exception.FzteExceptionEnum;

/**
 * @Classname ApiResponse
 * @Description 统一响应对象
 * @Version 1.0.0
 * @Date 2022/10/14 20:52
 * @Created by 忆霁昕
 */
public class ApiRestResponse<T> {
    private Integer status;
    private String msg;
    private T data;
    private static final Integer OK_CODE = 10000;
    private static final String OK_MSG = "SUCCESS";

    public ApiRestResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiRestResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ApiRestResponse() {
        this(OK_CODE, OK_MSG);
    }

    public static <T> ApiRestResponse success() {
        return new ApiRestResponse();
    }

    public static <T> ApiRestResponse success(T data) {
        ApiRestResponse response = new ApiRestResponse();
        response.setData(data);
        return response;
    }

    public static <T> ApiRestResponse error(Integer code, String msg) {
        return new ApiRestResponse(code, msg);
    }

    public static <T> ApiRestResponse error(FzteExceptionEnum ex) {

        return new ApiRestResponse(ex.getCode(), ex.getMsg());
    }




    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
