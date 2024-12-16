package com.atyinchao.blog.common.domain.dos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ArticleContentDO
 * @Description
 * @Date 2024/12/16 16:48
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleContentDO {

    private Long id;

    private Long articleId;

    private String content;
}
