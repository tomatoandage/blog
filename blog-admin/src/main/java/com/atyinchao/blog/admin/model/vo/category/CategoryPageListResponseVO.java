package com.atyinchao.blog.admin.model.vo.category;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName CategoryPageListResponseVO
 * @Description
 * @Date 2024/12/10 13:44
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Tag(name = "分类分页查询响应VO")
public class CategoryPageListResponseVO {

    private Long id;

    private String name;

    private String createTime;
}
