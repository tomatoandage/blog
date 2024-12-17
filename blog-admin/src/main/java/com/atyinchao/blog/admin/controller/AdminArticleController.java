package com.atyinchao.blog.admin.controller;

import com.atyinchao.blog.admin.model.vo.article.ArticlePageListRequestVO;
import com.atyinchao.blog.admin.model.vo.article.ArticlePageListResponseVO;
import com.atyinchao.blog.admin.service.AdminArticleService;
import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.utils.PageResponse;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdminArticleController
 * @Description
 * @Date 2024/12/17 14:06
 * @Author yinchao
 **/
@RequestMapping("/admin/article")
@RestController
public class AdminArticleController {

    @Resource
    public AdminArticleService adminArticleService;

    @PostMapping("/page")
    @ApiOperationLog(description = "查询文章列表")
    public PageResponse<ArticlePageListResponseVO> page(@RequestBody @Validated ArticlePageListRequestVO articlePageListRequestVO){
        return adminArticleService.page(articlePageListRequestVO);
    }

}
