package com.atyinchao.blog.admin.model.vo.tag;

import com.atyinchao.blog.common.model.BasePageQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

/**
 * @ClassName TagPageListRequestVO
 * @Description
 * @Date 2024/12/13 15:00
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagPageListRequestVO extends BasePageQuery {

    private String name;

    private Date startTime;

    private Date endTime;
}
