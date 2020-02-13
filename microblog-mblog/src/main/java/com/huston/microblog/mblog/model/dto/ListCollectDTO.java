package com.huston.microblog.mblog.model.dto;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class ListCollectDTO {
    private Long userId;
    private Long offset;
    private Long limit;

    public ListCollectDTO() {
    }

    public ListCollectDTO(Long userId, Long offset, Long limit) {
        this.userId = userId;
        this.offset = offset;
        this.limit = limit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
