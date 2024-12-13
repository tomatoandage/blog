package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.model.vo.category.CategoryAddRequestVO;
import com.atyinchao.blog.admin.model.vo.category.CategoryPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.category.CategoryPageListResponseVO;
import com.atyinchao.blog.admin.service.AdminCategoryService;
import com.atyinchao.blog.common.domain.dos.CategoryDO;
import com.atyinchao.blog.common.domain.mapper.CategoryMapper;
import com.atyinchao.blog.common.enums.ResponseCodeEnum;
import com.atyinchao.blog.common.exception.BusinessException;
import com.atyinchao.blog.common.utils.PageResponse;
import com.atyinchao.blog.common.utils.Response;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName AdminCategoryServiceImpl
 * @Description
 * @Date 2024/12/9 13:59
 * @Author yinchao
 **/

@Service
@Slf4j
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 添加分类
     */
    @Override
    public Response<String> addCategory(CategoryAddRequestVO categoryAddRequestVO) {
        CategoryDO categoryDO = new LambdaQueryChainWrapper<>(categoryMapper).eq(CategoryDO::getName, categoryAddRequestVO.getName()).one();
        if (Objects.nonNull(categoryDO)) {
            log.info("分类名称：{},该分类已存在", categoryDO.getName());
            throw new BusinessException(ResponseCodeEnum.CATEGORY_IS_EXISTS);
        }

        //构造DO类
        CategoryDO addCategoryDO = CategoryDO.builder().name(categoryAddRequestVO.getName()).build();

        //insert
        categoryMapper.insert(addCategoryDO);

        return Response.success();
    }

    /**
     * 根据条件分页查询
     */
    @Override
    public PageResponse<CategoryPageListResponseVO> page(CategoryPageListRequestVO categoryPageListRequestVO) {
        long currentPage = categoryPageListRequestVO.getCurrentPage();
        long size = categoryPageListRequestVO.getSize();
        Page<CategoryDO> page= new Page<>(currentPage,size);

        String name = categoryPageListRequestVO.getName();
        Date startTime = categoryPageListRequestVO.getStartTime();
        Date endTime = categoryPageListRequestVO.getEndTime();
        LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();

                wrapper.like(StringUtils.isNotBlank(name), CategoryDO::getName, name.trim())
                .ge(Objects.nonNull(startTime), CategoryDO::getCreateTime, startTime)
                .le(Objects.nonNull(endTime), CategoryDO::getCreateTime, endTime)
                .orderByDesc(CategoryDO::getUpdateTime);

        Page<CategoryDO> categoryDOPage = categoryMapper.selectPage(page, wrapper);

        List<CategoryDO> categoryDOS = categoryDOPage.getRecords();
        // DO 转 VO
        List<CategoryPageListResponseVO> vos = null;
        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .map(categoryDO -> CategoryPageListResponseVO.builder()
                            .id(categoryDO.getId())
                            .name(categoryDO.getName())
                            .createTime(categoryDO.getCreateTime().toString())
                            .build())
                    .toList();
        }

        return PageResponse.success(categoryDOPage,vos);
    }
}
