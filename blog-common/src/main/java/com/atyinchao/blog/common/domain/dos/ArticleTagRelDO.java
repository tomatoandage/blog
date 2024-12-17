package com.atyinchao.blog.common.domain.dos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ArticleTagRelDO
 * @Description
 * @Date 2024/12/16 17:09
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleTagRelDO {

    private Long id;

    private Long articleId;

    private Long tagId;
}
