package com.atyinchao.blog.jwt.exception;

import javax.security.sasl.AuthenticationException;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/2
 */
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}
