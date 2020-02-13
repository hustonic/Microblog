package com.huston.microblog.mblog.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ListAgreeMicroblogDTO {
    private Long userId;
    private Long mblogId;
    @Min(value = 0, message = "offset>=0")
    private Long offset;
    @Min(value = 1, message = "limit>=1")
    private Long limit;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMblogId() {
        return mblogId;
    }

    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
