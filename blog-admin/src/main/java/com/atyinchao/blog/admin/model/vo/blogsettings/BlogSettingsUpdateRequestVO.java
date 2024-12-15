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
public class BlogSettingsUpdateRequestVO {

    private String id;

    private String logo;

    private String name;

    private String author;

    private String introduction;

    private String avatar;

    private String githubHomepage;

    private String csdnHomepage;

    private String giteeHomepage;

    private String zhihuHomepage;
}