package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.model.vo.article.ArticlePageListRequestVO;
import com.atyinchao.blog.admin.model.vo.article.ArticlePageListResponseVO;
import com.atyinchao.blog.admin.service.AdminArticleService;
import com.atyinchao.blog.common.domain.dos.ArticleDO;
import com.atyinchao.blog.common.domain.mapper.ArticleMapper;
import com.atyinchao.blog.common.utils.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName AdminArticleServiceImpl
 * @Description
 * @Date 2024/12/17 14:06
 * @Author yinchao
 **/
public class AdminArticleServiceImpl implements AdminArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Override
    public PageResponse<ArticlePageListResponseVO> page(ArticlePageListRequestVO articlePageListRequestVO) {
        long currentPage = articlePageListRequestVO.getCurrentPage();
        long size = articlePageListRequestVO.getSize();
        Page<ArticleDO> page = new Page<>(currentPage,size);

        String title = articlePageListRequestVO.getTitle();
        Date startTime = articlePageListRequestVO.getStartTime();
        Date endTime = articlePageListRequestVO.getEndTime();

        LambdaQueryWrapper<ArticleDO> wrapper = new LambdaQueryWrapper<>();

        wrapper.like(StringUtils.isNotBlank(title),ArticleDO::getTitle,title)
                .ge(Objects.nonNull(startTime),ArticleDO::getCreateTime,startTime)
                .le(Objects.nonNull(endTime),ArticleDO::getCreateTime,endTime)
                .orderByDesc(ArticleDO::getUpdateTime);

        Page<ArticleDO> articleDOPage = articleMapper.selectPage(page, wrapper);

        List<ArticleDO> articleDOS = articleDOPage.getRecords();

        List<ArticlePageListResponseVO> vos = null;

        articleDOS.stream()
                .map(articleDO -> {
                    ArticlePageListResponseVO.builder()
                            .
                })
    }
}
