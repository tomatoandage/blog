package com.atyinchao.blog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserRoleDO
 * @Description
 * @Date 2024/12/5 20:52
 * @Author yinchao
 **/
@Data
@Builder
@TableName("t_user_role")
public class UserRoleDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String role;

    private Date createTime;
}
