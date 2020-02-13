package com.huston.microblog.auth.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RolePermissionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source Table: role_permission")
    public static final RolePermission rolePermission = new RolePermission();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.role_perm_id")
    public static final SqlColumn<Long> rolePermId = rolePermission.rolePermId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.role_id")
    public static final SqlColumn<Long> roleId = rolePermission.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source field: role_permission.perm_id")
    public static final SqlColumn<Long> permId = rolePermission.permId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source Table: role_permission")
    public static final class RolePermission extends SqlTable {
        public final SqlColumn<Long> rolePermId = column("role_perm_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permId = column("perm_id", JDBCType.BIGINT);

        public RolePermission() {
            super("role_permission");
        }
    }
}