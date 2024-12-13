package com.atyinchao.blog.admin.model.vo.tag;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName TagPageListResponseVO
 * @Description
 * @Date 2024/12/13 15:01
 * @Author yinchao
 **/
@Data
public class TagPageListResponseVO {

    private Long id;

    private String name;

    private Date createTime;
}
