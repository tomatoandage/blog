package com.atyinchao.blog.common.domain.dos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ArticleDO
 * @Description
 * @Date 2024/12/16 16:47
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDO {

    private Long id;

    private String title;

    private String cover;

    private String summary;

    private String createTime;

    private String updateTime;

    private boolean isDeleted;

    private Integer readNum;

}
