package com.huston.microblog.verification.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VerificationDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source Table: verification")
    public static final Verification verification = new Verification();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_id")
    public static final SqlColumn<Long> verId = verification.verId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_type")
    public static final SqlColumn<Byte> verType = verification.verType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_desc")
    public static final SqlColumn<String> verDesc = verification.verDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_real_name")
    public static final SqlColumn<String> verRealName = verification.verRealName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_identity_card")
    public static final SqlColumn<String> verIdentityCard = verification.verIdentityCard;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_state")
    public static final SqlColumn<Byte> verState = verification.verState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_res_desc")
    public static final SqlColumn<String> verResDesc = verification.verResDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.ver_time")
    public static final SqlColumn<Date> verTime = verification.verTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source field: verification.user_id")
    public static final SqlColumn<Long> userId = verification.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source Table: verification")
    public static final class Verification extends SqlTable {
        public final SqlColumn<Long> verId = column("ver_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> verType = column("ver_type", JDBCType.TINYINT);

        public final SqlColumn<String> verDesc = column("ver_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> verRealName = column("ver_real_name", JDBCType.VARCHAR);

        public final SqlColumn<String> verIdentityCard = column("ver_identity_card", JDBCType.VARCHAR);

        public final SqlColumn<Byte> verState = column("ver_state", JDBCType.TINYINT);

        public final SqlColumn<String> verResDesc = column("ver_res_desc", JDBCType.VARCHAR);

        public final SqlColumn<Date> verTime = column("ver_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public Verification() {
            super("verification");
        }
    }
}