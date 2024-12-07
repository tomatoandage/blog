package com.atyinchao.blog.web.controller;

import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.utils.Response;
import com.atyinchao.blog.web.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/11/30
 */
@RestController
@Slf4j
@Tag(name = "Test服务")
public class TestController {

    @GetMapping("/admin/test")
    @ApiOperationLog(description = "测试接口")
    @Operation(summary = "admin/test")
    public Response test() {
        return Response.success();
    }

    @PostMapping("/login")
    @ApiOperationLog(description = "登录接口")
    @Operation(summary = "login")
    public Response login(){
        return Response.success();
    }
    @GetMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @Operation(summary = "test")
    public Response test1() {
        return Response.success();
    }

    @PostMapping("/admin/update")
    @ApiOperationLog(description = "测试更新接口")
    @Operation(summary = "测试更新接口")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response testUpdate() {
        log.info("更新成功...");
        return Response.success();
    }
}
