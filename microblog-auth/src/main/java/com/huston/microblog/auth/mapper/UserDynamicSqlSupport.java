package com.huston.microblog.auth.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.978+08:00", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.981+08:00", comments="Source field: user.user_id")
    public static final SqlColumn<Long> userId = user.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.982+08:00", comments="Source field: user.user_name")
    public static final SqlColumn<String> userName = user.userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.982+08:00", comments="Source field: user.user_name_set_time")
    public static final SqlColumn<Date> userNameSetTime = user.userNameSetTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.982+08:00", comments="Source field: user.user_name_update_times")
    public static final SqlColumn<Byte> userNameUpdateTimes = user.userNameUpdateTimes;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.982+08:00", comments="Source field: user.user_email")
    public static final SqlColumn<String> userEmail = user.userEmail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.982+08:00", comments="Source field: user.user_phone")
    public static final SqlColumn<String> userPhone = user.userPhone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.982+08:00", comments="Source field: user.user_password")
    public static final SqlColumn<String> userPassword = user.userPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.983+08:00", comments="Source field: user.user_sex")
    public static final SqlColumn<Byte> userSex = user.userSex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.983+08:00", comments="Source field: user.user_birthday")
    public static final SqlColumn<Date> userBirthday = user.userBirthday;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.983+08:00", comments="Source field: user.user_intro")
    public static final SqlColumn<String> userIntro = user.userIntro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.983+08:00", comments="Source field: user.res_id")
    public static final SqlColumn<Long> resId = user.resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.983+08:00", comments="Source field: user.user_cre_time")
    public static final SqlColumn<Date> userCreTime = user.userCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.984+08:00", comments="Source field: user.user_avail_time")
    public static final SqlColumn<Date> userAvailTime = user.userAvailTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.98+08:00", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<Date> userNameSetTime = column("user_name_set_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Byte> userNameUpdateTimes = column("user_name_update_times", JDBCType.TINYINT);

        public final SqlColumn<String> userEmail = column("user_email", JDBCType.VARCHAR);

        public final SqlColumn<String> userPhone = column("user_phone", JDBCType.VARCHAR);

        public final SqlColumn<String> userPassword = column("user_password", JDBCType.VARCHAR);

        public final SqlColumn<Byte> userSex = column("user_sex", JDBCType.TINYINT);

        public final SqlColumn<Date> userBirthday = column("user_birthday", JDBCType.DATE);

        public final SqlColumn<String> userIntro = column("user_intro", JDBCType.VARCHAR);

        public final SqlColumn<Long> resId = column("res_id", JDBCType.BIGINT);

        public final SqlColumn<Date> userCreTime = column("user_cre_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> userAvailTime = column("user_avail_time", JDBCType.TIMESTAMP);

        public User() {
            super("user");
        }
    }
}