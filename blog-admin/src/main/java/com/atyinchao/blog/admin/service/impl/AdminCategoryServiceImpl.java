package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.model.vo.category.CategoryAddRequestVO;
import com.atyinchao.blog.admin.service.AdminCategoryService;
import com.atyinchao.blog.common.domain.dos.CategoryDO;
import com.atyinchao.blog.common.domain.mapper.CategoryMapper;
import com.atyinchao.blog.common.enums.ResponseCodeEnum;
import com.atyinchao.blog.common.exception.BusinessException;
import com.atyinchao.blog.common.utils.Response;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
}
