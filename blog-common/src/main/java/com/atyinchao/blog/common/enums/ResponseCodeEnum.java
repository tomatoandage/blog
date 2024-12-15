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
    LOGIN_FAIL("20000", "登录失败"),
    USERNAME_OR_PWD_ERROR("20001", "用户名或密码错误"),
    //参数校验错误
    PARAM_NOT_VALID("10001","参数错误"),

    UNAUTHORIZED("20002", "无访问权限，请先登录哦！"),

    FORBIDDEN("20004", "你的权限不够呢，快联系管理员获取权限吧！！"),

    CATEGORY_IS_EXISTS("20005","分类已存在"),

    CATEGORY_IS_NOT_EXISTS("20006","分类不存在"),

    FILE_UPLOAD_FAILED("20007","上传文件失败！" );

    private final String errorCode;

    private final String errorMessage;
}
