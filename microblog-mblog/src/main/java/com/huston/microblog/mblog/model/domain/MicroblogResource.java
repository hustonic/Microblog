package com.huston.microblog.mblog.model.domain;

import javax.annotation.Generated;

public class MicroblogResource {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.mblog_res_id")
    private Long mblogResId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.mblog_id")
    private Long mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.res_id")
    private Long resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.mblog_res_id")
    public Long getMblogResId() {
        return mblogResId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.mblog_res_id")
    public void setMblogResId(Long mblogResId) {
        this.mblogResId = mblogResId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.mblog_id")
    public Long getMblogId() {
        return mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.654+08:00", comments="Source field: microblog_resource.mblog_id")
    public void setMblogId(Long mblogId) {
        this.mblogId = mblogId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source field: microblog_resource.res_id")
    public Long getResId() {
        return resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source field: microblog_resource.res_id")
    public void setResId(Long resId) {
        this.resId = resId;
    }
}