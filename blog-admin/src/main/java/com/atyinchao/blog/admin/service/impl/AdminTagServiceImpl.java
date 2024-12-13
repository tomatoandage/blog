package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.model.vo.tag.TagPageListRequestVO;
import com.atyinchao.blog.admin.model.vo.tag.TagPageListResponseVO;
import com.atyinchao.blog.admin.service.AdminTagService;
import com.atyinchao.blog.common.utils.PageResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public PageResponse<TagPageListResponseVO> page(TagPageListRequestVO tagPageListRequestVO) {
        return null;
    }
}
