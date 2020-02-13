package com.huston.microblog.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class ListCommentDTO {

    @ApiModelProperty(value = "微博ID", required = true, example = "0")
    @NotNull(message = "mblogId不能为null")
    private Long mblogId;

    @ApiModelProperty(value="父评论ID", example = "0")
    private Long commIdParent;

    @Min(value = 0, message = "offset >= 0")
    private Long offset;

    @Min(value = 1, message = "limit >= 1")
    private Long limit;
}
