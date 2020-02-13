package com.huston.microblog.relation.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RelationGroupDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source Table: relation_group")
    public static final RelationGroup relationGroup = new RelationGroup();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source field: relation_group.rela_grp_id")
    public static final SqlColumn<Long> relaGrpId = relationGroup.relaGrpId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.478+08:00", comments="Source field: relation_group.rela_id")
    public static final SqlColumn<Long> relaId = relationGroup.relaId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.478+08:00", comments="Source field: relation_group.group_id")
    public static final SqlColumn<Long> groupId = relationGroup.groupId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.477+08:00", comments="Source Table: relation_group")
    public static final class RelationGroup extends SqlTable {
        public final SqlColumn<Long> relaGrpId = column("rela_grp_id", JDBCType.BIGINT);

        public final SqlColumn<Long> relaId = column("rela_id", JDBCType.BIGINT);

        public final SqlColumn<Long> groupId = column("group_id", JDBCType.BIGINT);

        public RelationGroup() {
            super("relation_group");
        }
    }
}