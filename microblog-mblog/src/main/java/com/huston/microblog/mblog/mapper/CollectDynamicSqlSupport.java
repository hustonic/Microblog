package com.huston.microblog.mblog.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CollectDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.65+08:00", comments="Source Table: collect")
    public static final Collect collect = new Collect();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.65+08:00", comments="Source field: collect.collect_id")
    public static final SqlColumn<Long> collectId = collect.collectId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.65+08:00", comments="Source field: collect.user_id")
    public static final SqlColumn<Long> userId = collect.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.651+08:00", comments="Source field: collect.mblog_id")
    public static final SqlColumn<Long> mblogId = collect.mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.651+08:00", comments="Source field: collect.collect_time")
    public static final SqlColumn<Date> collectTime = collect.collectTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.65+08:00", comments="Source Table: collect")
    public static final class Collect extends SqlTable {
        public final SqlColumn<Long> collectId = column("collect_id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> mblogId = column("mblog_id", JDBCType.BIGINT);

        public final SqlColumn<Date> collectTime = column("collect_time", JDBCType.TIMESTAMP);

        public Collect() {
            super("collect");
        }
    }
}