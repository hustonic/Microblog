package com.huston.microblog.auth.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PermissionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source Table: permission")
    public static final Permission permission = new Permission();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source field: permission.perm_id")
    public static final SqlColumn<Long> permId = permission.permId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source field: permission.perm_name")
    public static final SqlColumn<String> permName = permission.permName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source field: permission.perm_desc")
    public static final SqlColumn<String> permDesc = permission.permDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source field: permission.perm_url")
    public static final SqlColumn<String> permUrl = permission.permUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source field: permission.perm_cre_time")
    public static final SqlColumn<Date> permCreTime = permission.permCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.026+08:00", comments="Source Table: permission")
    public static final class Permission extends SqlTable {
        public final SqlColumn<Long> permId = column("perm_id", JDBCType.BIGINT);

        public final SqlColumn<String> permName = column("perm_name", JDBCType.VARCHAR);

        public final SqlColumn<String> permDesc = column("perm_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> permUrl = column("perm_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> permCreTime = column("perm_cre_time", JDBCType.TIMESTAMP);

        public Permission() {
            super("permission");
        }
    }
}