package com.huston.microblog.common.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class CommentDTO {
    private Long commId;
    private Long resId;
    private Long mblogId;
    private Long commIdParent;
    private Date commCreTime;
    private Long userId;
    private String commText;
}
