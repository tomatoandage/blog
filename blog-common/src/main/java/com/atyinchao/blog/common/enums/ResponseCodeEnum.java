package com.atyinchao.blog.common.enums;

import com.atyinchao.blog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 响应异常码枚举
 * @Author yinchao
 * @Date 2024/11/30
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    //通用异常状态码
    SYSTEM_ERROR("10000","出错啦，后台小哥正在努力修复中..."),

    //业务异常状态码
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),

    //参数校验错误
    PARAM_NOT_VALID("10001","参数错误"),

    ;

    private String errorCode;

    private String errorMessage;
}
