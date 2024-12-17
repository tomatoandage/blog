package com.atyinchao.blog.admin.model.vo.article;

import com.atyinchao.blog.common.model.BasePageQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

/**
 * @ClassName ArticleListRequestVO
 * @Description
 * @Date 2024/12/17 14:31
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticlePageListRequestVO extends BasePageQuery {

    /**
     * 文章标题
     */
    private String title;

    /**
     * 起始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}
