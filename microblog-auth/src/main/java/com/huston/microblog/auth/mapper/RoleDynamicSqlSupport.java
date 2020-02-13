package com.huston.microblog.auth.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source Table: role")
    public static final Role role = new Role();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_id")
    public static final SqlColumn<Long> roleId = role.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_name")
    public static final SqlColumn<String> roleName = role.roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source field: role.role_desc")
    public static final SqlColumn<String> roleDesc = role.roleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source field: role.role_cre_time")
    public static final SqlColumn<Date> roleCreTime = role.roleCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.019+08:00", comments="Source Table: role")
    public static final class Role extends SqlTable {
        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<String> roleDesc = column("role_desc", JDBCType.VARCHAR);

        public final SqlColumn<Date> roleCreTime = column("role_cre_time", JDBCType.TIMESTAMP);

        public Role() {
            super("role");
        }
    }
}