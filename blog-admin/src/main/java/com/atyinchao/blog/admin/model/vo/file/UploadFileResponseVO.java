package com.atyinchao.blog.admin.model.vo.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadFileResponseVO {

    //文件链接
    private String url;
}
