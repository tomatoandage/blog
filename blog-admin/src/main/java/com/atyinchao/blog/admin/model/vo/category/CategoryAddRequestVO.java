package com.atyinchao.blog.admin.model.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.Length;

/**
 * @ClassName CategoryAddRequestVO
 * @Description
 * @Date 2024/12/9 11:08
 * @Author yinchao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Tag(name = "添加分类VO")
public class CategoryAddRequestVO {

    @NotBlank(message = "分类名称不能为空")
    @Min(value = 1L, message = "分类名称长度不小于2个字符")
    @Max(value = 10L, message = "分类名称长度不高于10个字符")
    private String name;
}
