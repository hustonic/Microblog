package com.huston.microblog.common.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Data
public class AgreeCommentDTO {
    private Long agreeId;

    private Long userId;

    private Long commId;

    private Date agreeTime;
}
