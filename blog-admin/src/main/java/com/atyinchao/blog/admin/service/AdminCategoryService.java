package com.atyinchao.blog.admin.service;

import com.atyinchao.blog.admin.model.vo.category.CategoryAddRequestVO;
import com.atyinchao.blog.common.utils.Response;

/**
 * @ClassName CategoryService
 * @Description
 * @Date 2024/12/9 13:55
 * @Author yinchao
 **/
public interface AdminCategoryService {
    Response<String> addCategory(CategoryAddRequestVO categoryAddRequestVO);
}
