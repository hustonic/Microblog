package com.huston.microblog.verification.model.domain;

import javax.annotation.Generated;

public class VerificationPicture {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_pic_id")
    private Long verPicId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_id")
    private Long verId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.res_id")
    private Long resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_pic_id")
    public Long getVerPicId() {
        return verPicId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_pic_id")
    public void setVerPicId(Long verPicId) {
        this.verPicId = verPicId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_id")
    public Long getVerId() {
        return verId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_id")
    public void setVerId(Long verId) {
        this.verId = verId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.res_id")
    public Long getResId() {
        return resId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.res_id")
    public void setResId(Long resId) {
        this.resId = resId;
    }
}