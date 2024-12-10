package com.atyinchao.blog.admin.model.vo.category;

import com.atyinchao.blog.common.model.BasePageQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName CategoryPageListRequestVO
 * @Description
 * @Date 2024/12/10 10:02
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Tag(name = "分类分页查询请求VO")
public class CategoryPageListRequestVO extends BasePageQuery {

    /**
     * 分类名称
     */
    private String name;

    /**
     * 起始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}
