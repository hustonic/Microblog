package com.huston.microblog.mblog.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MicroblogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.612+08:00", comments="Source Table: microblog")
    public static final Microblog microblog = new Microblog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.614+08:00", comments="Source field: microblog.mblog_id")
    public static final SqlColumn<Long> mblogId = microblog.mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.615+08:00", comments="Source field: microblog.mblog_type")
    public static final SqlColumn<Byte> mblogType = microblog.mblogType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.615+08:00", comments="Source field: microblog.mblog_id_forward")
    public static final SqlColumn<Long> mblogIdForward = microblog.mblogIdForward;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.615+08:00", comments="Source field: microblog.mblog_pub_time")
    public static final SqlColumn<Date> mblogPubTime = microblog.mblogPubTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.616+08:00", comments="Source field: microblog.user_id")
    public static final SqlColumn<Long> userId = microblog.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.616+08:00", comments="Source field: microblog.mblog_text")
    public static final SqlColumn<String> mblogText = microblog.mblogText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.614+08:00", comments="Source Table: microblog")
    public static final class Microblog extends SqlTable {
        public final SqlColumn<Long> mblogId = column("mblog_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> mblogType = column("mblog_type", JDBCType.TINYINT);

        public final SqlColumn<Long> mblogIdForward = column("mblog_id_forward", JDBCType.BIGINT);

        public final SqlColumn<Date> mblogPubTime = column("mblog_pub_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> mblogText = column("mblog_text", JDBCType.LONGVARCHAR);

        public Microblog() {
            super("microblog");
        }
    }
}