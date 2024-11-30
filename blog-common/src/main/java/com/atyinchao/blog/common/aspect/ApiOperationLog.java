package com.atyinchao.blog.common.aspect;

import java.lang.annotation.*;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/11/30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiOperationLog {

    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
