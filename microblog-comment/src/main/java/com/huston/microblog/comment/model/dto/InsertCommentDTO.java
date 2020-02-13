package com.huston.microblog.comment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertCommentDTO {
    private Long resId;
    private Long mblogId;
    private Long commIdParent;
    private Long userId;
    private String commText;

}
