package com.atyinchao.blog.admin.model.vo.blogsettings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogSettingsUpdateResponseVO {

    private Long id;

    private String logo;

    private String name;

    private String author;

    private String introduction;

    private String avatar;

    private String github_homepage;

    private String csdn_homepage;

    private String gitee_homepage;

    private String zhihu_homepage;
}
