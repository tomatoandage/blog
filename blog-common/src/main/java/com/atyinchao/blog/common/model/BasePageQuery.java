package com.atyinchao.blog.common.model;

import lombok.Data;

/**
 * @ClassName BasePageQuery
 * @Description
 * @Date 2024/12/9 16:23
 * @Author yinchao
 **/
@Data
public class BasePageQuery {

    /**
     * 每页显示的记录数，默认10条
     */
    private long size = 10L;

    /**
     * 当前页码
     */
    private long currentPage = 1L;
}
