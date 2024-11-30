package com.atyinchao.blog.common.utils;

import com.atyinchao.blog.common.exception.BaseExceptionInterface;
import com.atyinchao.blog.common.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 响应参数工具类
 * @Author yinchao
 * @Date 2024/11/30
 */
@Data
public class Response<T> implements Serializable {

    //是否成功，默认为true
    private boolean success = true;

    //响应消息
    private String message;

    //异常码
    private String errorCode;

    //响应数据
    private T data;

    // ====================== 成功响应 ===========================
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    // ====================== 失败响应 ===========================
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(BusinessException businessException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(businessException.getErrorCode());
        response.setMessage(businessException.getErrorMessage());
        return response;
    }

    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(baseExceptionInterface.getErrorCode());
        response.setMessage(baseExceptionInterface.getErrorMessage());
        return response;
    }
}
