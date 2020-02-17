package com.huston.microblog.verification.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VerificationPictureDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    public static final VerificationPicture verificationPicture = new VerificationPicture();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_pic_id")
    public static final SqlColumn<Long> verPicId = verificationPicture.verPicId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.ver_id")
    public static final SqlColumn<Long> verId = verificationPicture.verId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source field: verification_picture.res_id")
    public static final SqlColumn<Long> resId = verificationPicture.resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    public static final class VerificationPicture extends SqlTable {
        public final SqlColumn<Long> verPicId = column("ver_pic_id", JDBCType.BIGINT);

        public final SqlColumn<Long> verId = column("ver_id", JDBCType.BIGINT);

        public final SqlColumn<Long> resId = column("res_id", JDBCType.BIGINT);

        public VerificationPicture() {
            super("verification_picture");
        }
    }
}