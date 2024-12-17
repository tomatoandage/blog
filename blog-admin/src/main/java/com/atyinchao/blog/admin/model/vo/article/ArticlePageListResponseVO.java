package com.atyinchao.blog.admin.model.vo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ArticlePageListResponseVO
 * @Description
 * @Date 2024/12/17 14:31
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticlePageListResponseVO {

    private Long id;

    private String title;

    private String cover;

    private String summary;

    private String createTime;

    private String updateTime;

    private boolean isDeleted;

    private Integer readNum;


}
