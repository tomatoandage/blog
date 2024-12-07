package com.atyinchao.blog.common.exception;

import com.atyinchao.blog.common.enums.ResponseCodeEnum;
import com.atyinchao.blog.common.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @Description 全局异常处理
 * @Author yinchao
 * @Date 2024/11/30
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  捕获自定义异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public Response<Object> handleBussesException(HttpServletRequest request, BusinessException e) {
        log.warn("{} request fail, errorCode: {}, errorMessage: {}", request.getRequestURI(), e.getErrorCode(), e.getErrorMessage());
        return Response.fail(e);
    }

    @ExceptionHandler({ AuthorizationDeniedException.class})
    public void throwAccessDeniedException(AuthorizationDeniedException e) throws AccessDeniedException {
        //捕获到鉴权失败异常，主动抛出，交给 RestAccessDeniedHandler 去处理
        log.info("============= 捕获到 AuthorizationDeniedException");
        throw e;
    }

    /**
     * 其他类型异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request, Exception e) {
        log.error("{} request error, ", request.getRequestURI(), e);
        return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 捕获参数校验异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        //参数错误异常码
        String errorCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();

        //获取 BindingResult
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder sb = new StringBuilder();

        //获取校验不通过的字段，并组合错误信息，格式为：email 邮箱格式不正确，当前值：‘112345qq.com’
        Optional.ofNullable(bindingResult.getFieldErrors()).ifPresent(errors -> {
            errors.forEach(error -> {
                sb.append(error.getField())
                        .append(" ")
                        .append(error.getDefaultMessage())
                        .append(", 当前值: ")
                        .append(error.getRejectedValue())
                        .append("'; ");
            });
        });

        //错误信息
        String errorMessage = sb.toString();

        log.warn("{} request error, errorCode: {}, errorMessage: {}", request.getRequestURI(),errorCode,errorMessage);

        return Response.fail(errorCode,errorMessage);
    }




}
