package com.huston.microblog.auth.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source Table: user_role")
    public static final UserRole userRole = new UserRole();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source field: user_role.user_role_id")
    public static final SqlColumn<Long> userRoleId = userRole.userRoleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.016+08:00", comments="Source field: user_role.user_id")
    public static final SqlColumn<Long> userId = userRole.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.016+08:00", comments="Source field: user_role.role_id")
    public static final SqlColumn<Long> roleId = userRole.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.015+08:00", comments="Source Table: user_role")
    public static final class UserRole extends SqlTable {
        public final SqlColumn<Long> userRoleId = column("user_role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public UserRole() {
            super("user_role");
        }
    }
}