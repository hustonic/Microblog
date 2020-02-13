package com.huston.microblog.relation.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class GroupDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source Table: group")
    public static final Group group = new Group();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.group_id")
    public static final SqlColumn<Long> groupId = group.groupId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source field: group.group_name")
    public static final SqlColumn<String> groupName = group.groupName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source field: group.group_desc")
    public static final SqlColumn<String> groupDesc = group.groupDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source field: group.user_id")
    public static final SqlColumn<Long> userId = group.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.474+08:00", comments="Source Table: group")
    public static final class Group extends SqlTable {
        public final SqlColumn<Long> groupId = column("group_id", JDBCType.BIGINT);

        public final SqlColumn<String> groupName = column("group_name", JDBCType.VARCHAR);

        public final SqlColumn<String> groupDesc = column("group_desc", JDBCType.VARCHAR);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public Group() {
            super("group");
        }
    }
}