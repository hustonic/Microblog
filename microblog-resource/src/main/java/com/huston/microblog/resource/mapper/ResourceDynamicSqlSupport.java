package com.huston.microblog.resource.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.428+08:00", comments="Source Table: resource")
    public static final Resource resource = new Resource();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.431+08:00", comments="Source field: resource.res_id")
    public static final SqlColumn<Long> resId = resource.resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.431+08:00", comments="Source field: resource.res_url")
    public static final SqlColumn<String> resUrl = resource.resUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.431+08:00", comments="Source field: resource.res_type")
    public static final SqlColumn<Byte> resType = resource.resType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.432+08:00", comments="Source field: resource.res_usage")
    public static final SqlColumn<Byte> resUsage = resource.resUsage;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.432+08:00", comments="Source field: resource.res_cre_time")
    public static final SqlColumn<Date> resCreTime = resource.resCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.432+08:00", comments="Source field: resource.user_id")
    public static final SqlColumn<Long> userId = resource.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.43+08:00", comments="Source Table: resource")
    public static final class Resource extends SqlTable {
        public final SqlColumn<Long> resId = column("res_id", JDBCType.BIGINT);

        public final SqlColumn<String> resUrl = column("res_url", JDBCType.VARCHAR);

        public final SqlColumn<Byte> resType = column("res_type", JDBCType.TINYINT);

        public final SqlColumn<Byte> resUsage = column("res_usage", JDBCType.TINYINT);

        public final SqlColumn<Date> resCreTime = column("res_cre_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public Resource() {
            super("resource");
        }
    }
}