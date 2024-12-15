package com.atyinchao.blog.admin.controller;

import com.atyinchao.blog.admin.model.vo.blogsettings.BlogSettingsFindResponseVO;
import com.atyinchao.blog.admin.service.AdminBlogSettingsService;
import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.utils.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/14
 */
@RestController
@RequestMapping("/admin/blog/settings")
public class AdminBlogSettingsController {

    @Resource
    private AdminBlogSettingsService blogSettingsService;

    @GetMapping("/detail")
    @Schema(name = "博客设置查询")
    @ApiOperationLog(description = "博客设置查询")
    public Response<BlogSettingsFindResponseVO> find(){
        return blogSettingsService.find();
    }


}
