package com.atyinchao.blog.admin.service;

import com.atyinchao.blog.admin.model.vo.tag.TagPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.tag.TagPageListResponseVO;
import com.atyinchao.blog.common.utils.PageResponse;

/**
 * @ClassName AdminTagService
 * @Description
 * @Date 2024/12/13 16:02
 * @Author yinchao
 **/
public interface AdminTagService {
    PageResponse<TagPageListResponseVO> page(TagPageListRequestVO tagPageListRequestVO);
}
