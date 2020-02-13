package com.huston.microblog.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class InsertCommentVO {

    @ApiModelProperty(value = "评论附带的图片资源ID", example = "0")
    private Long resId;

    @ApiModelProperty(value="评论的微博ID", required = true, example = "0")
    @NotNull(message = "mblogId不能为null")
    private Long mblogId;

    @ApiModelProperty(value = "父评论ID", example = "0")
    private Long commIdParent;

    @ApiModelProperty(value = "评论文本", required = true)
    @NotBlank(message = "评论文本不能为空")
    private String commText;
}
