package com.huston.microblog.relation.model.domain;

import javax.annotation.Generated;

public class Group {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.473+08:00", comments="Source field: group.group_id")
    private Long groupId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.473+08:00", comments="Source field: group.group_name")
    private String groupName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.group_desc")
    private String groupDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.473+08:00", comments="Source field: group.group_id")
    public Long getGroupId() {
        return groupId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.473+08:00", comments="Source field: group.group_id")
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.473+08:00", comments="Source field: group.group_name")
    public String getGroupName() {
        return groupName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.473+08:00", comments="Source field: group.group_name")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.group_desc")
    public String getGroupDesc() {
        return groupDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.group_desc")
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}