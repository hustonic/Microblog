package com.huston.microblog.mblog.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AgreeMicroblogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source Table: agree_microblog")
    public static final AgreeMicroblog agreeMicroblog = new AgreeMicroblog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source field: agree_microblog.agree_id")
    public static final SqlColumn<Long> agreeId = agreeMicroblog.agreeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source field: agree_microblog.user_id")
    public static final SqlColumn<Long> userId = agreeMicroblog.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source field: agree_microblog.mblog_id")
    public static final SqlColumn<Long> mblogId = agreeMicroblog.mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source field: agree_microblog.agree_time")
    public static final SqlColumn<Date> agreeTime = agreeMicroblog.agreeTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.645+08:00", comments="Source Table: agree_microblog")
    public static final class AgreeMicroblog extends SqlTable {
        public final SqlColumn<Long> agreeId = column("agree_id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> mblogId = column("mblog_id", JDBCType.BIGINT);

        public final SqlColumn<Date> agreeTime = column("agree_time", JDBCType.TIMESTAMP);

        public AgreeMicroblog() {
            super("agree_microblog");
        }
    }
}