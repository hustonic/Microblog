package com.huston.microblog.relation.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Relation {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.425+08:00", comments="Source field: relation.rela_id")
    private Long relaId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.431+08:00", comments="Source field: relation.user_id_sub")
    private Long userIdSub;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.user_id_pub")
    private Long userIdPub;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.rela_remark")
    private String relaRemark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.rela_cre_time")
    private Date relaCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.431+08:00", comments="Source field: relation.rela_id")
    public Long getRelaId() {
        return relaId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.431+08:00", comments="Source field: relation.rela_id")
    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.431+08:00", comments="Source field: relation.user_id_sub")
    public Long getUserIdSub() {
        return userIdSub;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.user_id_sub")
    public void setUserIdSub(Long userIdSub) {
        this.userIdSub = userIdSub;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.user_id_pub")
    public Long getUserIdPub() {
        return userIdPub;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.user_id_pub")
    public void setUserIdPub(Long userIdPub) {
        this.userIdPub = userIdPub;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.rela_remark")
    public String getRelaRemark() {
        return relaRemark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.rela_remark")
    public void setRelaRemark(String relaRemark) {
        this.relaRemark = relaRemark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.rela_cre_time")
    public Date getRelaCreTime() {
        return relaCreTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.432+08:00", comments="Source field: relation.rela_cre_time")
    public void setRelaCreTime(Date relaCreTime) {
        this.relaCreTime = relaCreTime;
    }
}