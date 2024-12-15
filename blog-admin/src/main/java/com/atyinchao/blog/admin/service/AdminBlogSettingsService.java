package com.atyinchao.blog.admin.service;

import com.atyinchao.blog.admin.model.vo.blogsettings.BlogSettingsFindResponseVO;
import com.atyinchao.blog.common.utils.Response;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/15
 */
public interface AdminBlogSettingsService {
    Response<BlogSettingsFindResponseVO> find();
}
