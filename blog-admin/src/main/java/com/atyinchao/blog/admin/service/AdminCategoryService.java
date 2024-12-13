package com.atyinchao.blog.admin.service;

import com.atyinchao.blog.admin.model.vo.category.CategoryAddRequestVO;
import com.atyinchao.blog.admin.model.vo.category.CategoryPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.category.CategoryPageListResponseVO;
import com.atyinchao.blog.common.domain.dos.CategoryDO;
import com.atyinchao.blog.common.utils.PageResponse;
import com.atyinchao.blog.common.utils.Response;

/**
 * @ClassName CategoryService
 * @Description
 * @Date 2024/12/9 13:55
 * @Author yinchao
 **/
public interface AdminCategoryService {
    Response<String> addCategory(CategoryAddRequestVO categoryAddRequestVO);

    PageResponse<CategoryPageListResponseVO> page(CategoryPageListRequestVO categoryPageListRequestVO);
}
