package com.atyinchao.blog.admin.controller;

import com.atyinchao.blog.admin.model.vo.file.UploadFileResponseVO;
import com.atyinchao.blog.admin.service.AdminFileService;
import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.utils.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/15
 */
@RestController
@RequestMapping("/admin/file")
public class AdminFileController {

    @Resource
    private AdminFileService fileService;

    @PostMapping("/upload")
    @Schema(name = "文件上传")
    @ApiOperationLog(description = "文件上传")
    public Response<UploadFileResponseVO> upload(@RequestParam MultipartFile file) {
        return fileService.uploadFile(file);
    }
}
