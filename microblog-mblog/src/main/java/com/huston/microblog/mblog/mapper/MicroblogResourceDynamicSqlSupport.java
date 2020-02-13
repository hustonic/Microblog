package com.huston.microblog.mblog.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MicroblogResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source Table: microblog_resource")
    public static final MicroblogResource microblogResource = new MicroblogResource();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source field: microblog_resource.mblog_res_id")
    public static final SqlColumn<Long> mblogResId = microblogResource.mblogResId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source field: microblog_resource.mblog_id")
    public static final SqlColumn<Long> mblogId = microblogResource.mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source field: microblog_resource.res_id")
    public static final SqlColumn<Long> resId = microblogResource.resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source Table: microblog_resource")
    public static final class MicroblogResource extends SqlTable {
        public final SqlColumn<Long> mblogResId = column("mblog_res_id", JDBCType.BIGINT);

        public final SqlColumn<Long> mblogId = column("mblog_id", JDBCType.BIGINT);

        public final SqlColumn<Long> resId = column("res_id", JDBCType.BIGINT);

        public MicroblogResource() {
            super("microblog_resource");
        }
    }
}