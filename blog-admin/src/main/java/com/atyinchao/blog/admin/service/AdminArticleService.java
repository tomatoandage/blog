package com.atyinchao.blog.admin.service;

import com.atyinchao.blog.admin.model.vo.article.ArticlePageListRequestVO;
import com.atyinchao.blog.admin.model.vo.article.ArticlePageListResponseVO;
import com.atyinchao.blog.common.utils.PageResponse;

/**
 * @ClassName AdminArticleService
 * @Description
 * @Date 2024/12/17 14:06
 * @Author yinchao
 **/
public interface AdminArticleService {
    PageResponse<ArticlePageListResponseVO> page(ArticlePageListRequestVO articlePageListRequestVO);
}
