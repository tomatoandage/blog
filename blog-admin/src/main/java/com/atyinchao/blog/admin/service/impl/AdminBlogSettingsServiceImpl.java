package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.model.vo.blogsettings.BlogSettingsFindResponseVO;
import com.atyinchao.blog.admin.model.vo.blogsettings.BlogSettingsUpdateRequestVO;
import com.atyinchao.blog.admin.model.vo.blogsettings.BlogSettingsUpdateResponseVO;
import com.atyinchao.blog.admin.service.AdminBlogSettingsService;
import com.atyinchao.blog.common.domain.dos.BlogSettingsDO;
import com.atyinchao.blog.common.domain.mapper.BlogSettingsMapper;
import com.atyinchao.blog.common.utils.Response;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/15
 */
@Service
@Slf4j
public class AdminBlogSettingsServiceImpl implements AdminBlogSettingsService {

    @Resource
    private BlogSettingsMapper blogSettingsMapper;

    @Override
    public Response<BlogSettingsFindResponseVO> find() {

        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectOne(new LambdaQueryWrapper<>());

        BlogSettingsFindResponseVO blogSettingsFindResponseVO = new BlogSettingsFindResponseVO();

        BeanUtils.copyProperties(blogSettingsDO,blogSettingsFindResponseVO);

        return Response.success(blogSettingsFindResponseVO);
    }

    @Override
    public Response<BlogSettingsUpdateResponseVO> update(BlogSettingsUpdateRequestVO requestVO) {

        BlogSettingsDO blogSettingsDO = new BlogSettingsDO();

        BeanUtils.copyProperties(requestVO,blogSettingsDO);

        blogSettingsDO.setId(1L);

        blogSettingsMapper.updateById(blogSettingsDO);

        LambdaQueryWrapper<BlogSettingsDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BlogSettingsDO::getId,1);
        BlogSettingsDO blogSettingsDO1 = blogSettingsMapper.selectOne(wrapper);
        BlogSettingsUpdateResponseVO blogSettingsUpdateResponseVO = new BlogSettingsUpdateResponseVO();
        BeanUtils.copyProperties(blogSettingsDO1,blogSettingsUpdateResponseVO);

        return Response.success(blogSettingsUpdateResponseVO);
    }
}
