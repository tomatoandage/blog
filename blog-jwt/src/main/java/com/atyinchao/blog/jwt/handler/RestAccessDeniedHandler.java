package com.atyinchao.blog.jwt.handler;

import com.atyinchao.blog.common.enums.ResponseCodeEnum;
import com.atyinchao.blog.common.utils.Response;
import com.atyinchao.blog.jwt.utils.ResultUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName RestAccessDeniedHandler
 * @Description
 * @Date 2024/12/3 17:54
 * @Author yinchao
 **/
@Slf4j
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.warn("登录成功访问收保护的资源，但是权限不够: ", accessDeniedException);
        // 预留，后面引入多角色时会用到
        ResultUtil.fail(response, Response.fail(ResponseCodeEnum.FORBIDDEN));
    }
}