package com.huston.microblog.relation.model.dto;

import javax.validation.constraints.Size;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InsertGroupDTO {

    private String groupName;

    private String groupDesc;

    private Long userId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
