package com.atyinchao.blog.admin.model.vo.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName TagPageListResponseVO
 * @Description
 * @Date 2024/12/13 15:01
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagPageListResponseVO {

    private Long id;

    private String name;

    private Date createTime;
}
