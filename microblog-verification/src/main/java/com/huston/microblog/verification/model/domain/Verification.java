package com.huston.microblog.verification.model.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Verification {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.936+08:00", comments="Source field: verification.ver_id")
    private Long verId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_type")
    private Byte verType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_desc")
    private String verDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_real_name")
    private String verRealName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_identity_card")
    private String verIdentityCard;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_state")
    private Byte verState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_res_desc")
    private String verResDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_time")
    private Date verTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_id")
    public Long getVerId() {
        return verId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_id")
    public void setVerId(Long verId) {
        this.verId = verId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_type")
    public Byte getVerType() {
        return verType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_type")
    public void setVerType(Byte verType) {
        this.verType = verType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_desc")
    public String getVerDesc() {
        return verDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_desc")
    public void setVerDesc(String verDesc) {
        this.verDesc = verDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_real_name")
    public String getVerRealName() {
        return verRealName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_real_name")
    public void setVerRealName(String verRealName) {
        this.verRealName = verRealName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_identity_card")
    public String getVerIdentityCard() {
        return verIdentityCard;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_identity_card")
    public void setVerIdentityCard(String verIdentityCard) {
        this.verIdentityCard = verIdentityCard;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_state")
    public Byte getVerState() {
        return verState;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_state")
    public void setVerState(Byte verState) {
        this.verState = verState;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_res_desc")
    public String getVerResDesc() {
        return verResDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_res_desc")
    public void setVerResDesc(String verResDesc) {
        this.verResDesc = verResDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_time")
    public Date getVerTime() {
        return verTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.ver_time")
    public void setVerTime(Date verTime) {
        this.verTime = verTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.946+08:00", comments="Source field: verification.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}