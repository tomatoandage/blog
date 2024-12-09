package com.atyinchao.blog.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName PageResponse
 * @Description
 * @Date 2024/12/9 16:01
 * @Author yinchao
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponse<T> extends Response<List<T>>{

    /**
     * 总记录数
     */
    private long total = 0L;

    /**
     * 每页显示的记录数，默认10条
     */
    private long size = 10L;

    /**
     * 当前页码
     */
    private long currentPage;

    /**
     * 总页数
     */
    private long pages;

    public static <T> PageResponse<T> success(IPage<T> page, List<T> data) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setCurrentPage(Objects.isNull(page) ? 1L : page.getCurrent());
        response.setTotal(Objects.isNull(page) ? 0L : page.getTotal());
        response.setSize(Objects.isNull(page) ? 10L : page.getSize());
        response.setPages(Objects.isNull(page) ? 0L : page.getPages());
        response.setData(data);
        return response;
    }
}
