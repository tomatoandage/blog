package com.atyinchao.blog.admin.controller;

import com.atyinchao.blog.admin.model.vo.tag.TagPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.tag.TagPageListResponseVO;
import com.atyinchao.blog.admin.service.AdminTagService;
import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.utils.PageResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdminTagController
 * @Description
 * @Date 2024/12/13 14:12
 * @Author yinchao
 **/
@RestController
@Tag(name = "Admin标签管理")
@RequestMapping("/admin/tag")
public class AdminTagController {

    @Resource
    private AdminTagService tagService;

    @PostMapping("/page")
    @Schema(name = "分页查询")
    @ApiOperationLog(description = "分页查询")
    public PageResponse<TagPageListResponseVO> page(@RequestBody @Validated TagPageListRequestVO tagPageListRequestVO) {
        return tagService.page(tagPageListRequestVO);
    }

}
