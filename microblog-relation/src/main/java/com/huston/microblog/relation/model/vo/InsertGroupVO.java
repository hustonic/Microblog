package com.huston.microblog.relation.model.vo;

import javax.validation.constraints.Size;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class InsertGroupVO {

    @Size(max = 30, message = "分组名称不能超过30个字符")
    private String groupName;
    @Size(max = 255, message = "分组描述不能超过255个字符")
    private String groupDesc;

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
}
