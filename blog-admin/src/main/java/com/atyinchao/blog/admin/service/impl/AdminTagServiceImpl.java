package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.controller.AdminTagController;
import com.atyinchao.blog.admin.model.vo.tag.TagPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.tag.TagPageListResponseVO;
import com.atyinchao.blog.admin.service.AdminTagService;
import com.atyinchao.blog.common.domain.dos.TagDO;
import com.atyinchao.blog.common.domain.mapper.TagMapper;
import com.atyinchao.blog.common.utils.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @ClassName AdminTagServiceImpl
 * @Description
 * @Date 2024/12/13 16:32
 * @Author yinchao
 **/
@Service
@Slf4j
public class AdminTagServiceImpl implements AdminTagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public PageResponse<TagPageListResponseVO> page(TagPageListRequestVO tagPageListRequestVO) {
        long currentPage = tagPageListRequestVO.getCurrentPage();
        long size = tagPageListRequestVO.getSize();
        Page<TagDO> page = new Page<>(currentPage,size);
        Date startTime = tagPageListRequestVO.getStartTime();
        Date endTime = tagPageListRequestVO.getEndTime();
        String name = tagPageListRequestVO.getName();

        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name),TagDO::getName,name)
                .ge(Objects.nonNull(startTime),TagDO::getCreateTime,startTime)
                .le(Objects.nonNull(endTime),TagDO::getCreateTime,endTime)
                .orderByDesc(TagDO::getCreateTime);

        IPage<TagDO> tagDOIPage = tagMapper.selectPage(page,wrapper);

        List<TagDO> tagDOS = tagDOIPage.getRecords();

        List<TagPageListResponseVO> tagPageListResponseVOS = null;

        if (!CollectionUtils.isEmpty(tagDOS)){
            tagPageListResponseVOS = tagDOS.stream()
                    .map(tagDO -> TagPageListResponseVO.builder()
                            .id(tagDO.getId())
                            .name(tagDO.getName())
                            .createTime(tagDO.getCreateTime())
                            .build()
                    ).toList();
        }
        return PageResponse.success(tagDOIPage,tagPageListResponseVOS);
    }
}
