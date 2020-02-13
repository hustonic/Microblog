package com.huston.microblog.relation.model.domain;

import javax.annotation.Generated;

public class RelationGroup {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_grp_id")
    private Long relaGrpId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_id")
    private Long relaId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.group_id")
    private Long groupId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_grp_id")
    public Long getRelaGrpId() {
        return relaGrpId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_grp_id")
    public void setRelaGrpId(Long relaGrpId) {
        this.relaGrpId = relaGrpId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_id")
    public Long getRelaId() {
        return relaId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_id")
    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.group_id")
    public Long getGroupId() {
        return groupId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.group_id")
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}