package com.atyinchao.blog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName TagDO
 * @Description
 * @Date 2024/12/13 16:40
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_tag")
public class TagDO {

    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private boolean isDeleted;

}
