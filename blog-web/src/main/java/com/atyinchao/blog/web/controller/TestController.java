package com.atyinchao.blog.web.controller;

import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.utils.Response;
import com.atyinchao.blog.web.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/11/30
 */
@RestController
@Slf4j
@Tag(name = "test类")
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @Operation(summary = "test方法")
    public Response test(@RequestBody @Validated User user) {
        return Response.success();
    }
}
