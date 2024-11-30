package com.atyinchao.blog.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description 业务异常
 * @Author yinchao
 * @Date 2024/11/30
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {

    //异常码
    private String errorCode;

    //错误信息
    private String errorMessage;

    public BusinessException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
