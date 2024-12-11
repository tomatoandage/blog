package com.atyinchao.blog.admin.controller;

import com.atyinchao.blog.admin.model.vo.category.CategoryAddRequestVO;
import com.atyinchao.blog.admin.model.vo.category.CategoryPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.category.CategoryPageListResponseVO;
import com.atyinchao.blog.admin.service.AdminCategoryService;
import com.atyinchao.blog.common.aspect.ApiOperationLog;
import com.atyinchao.blog.common.domain.dos.CategoryDO;
import com.atyinchao.blog.common.utils.PageResponse;
import com.atyinchao.blog.common.utils.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CategoryController
 * @Description
 * @Date 2024/12/9 13:52
 * @Author yinchao
 **/
@RestController
@Tag(name = "分类操作类")
@RequestMapping("/category")
public class AdminCategoryController {

    @Resource
    private AdminCategoryService categoryService;

    @PostMapping("/addCategory")
    @Schema(name = "添加分类")
    @ApiOperationLog(description = "添加分类")
    public Response<String> addCategory(@RequestBody @Validated CategoryAddRequestVO categoryAddRequestVO) {
        return categoryService.addCategory(categoryAddRequestVO);
    }

    @PostMapping("/page")
    @Schema(name = "分类分页查询")
    @ApiOperationLog(description = "分类分页查询")
    public PageResponse<CategoryDO,CategoryPageListResponseVO> page(@RequestBody @Validated CategoryPageListRequestVO categoryPageListRequestVO){
        PageResponse<CategoryDO, CategoryPageListResponseVO> page = categoryService.page(categoryPageListRequestVO);
        return page;
    }
}
