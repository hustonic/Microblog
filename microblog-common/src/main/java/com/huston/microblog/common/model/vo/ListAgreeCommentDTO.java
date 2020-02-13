package com.huston.microblog.common.model.vo;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class ListAgreeCommentDTO {

    private Long userId;

    private Long commId;

    @Min(value = 0, message = "offset>=0")
    private Long offset;

    @Min(value = 1, message = "limit>=1")
    private Long limit;
}
