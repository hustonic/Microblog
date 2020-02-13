package com.huston.microblog.relation.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RelationDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.436+08:00", comments="Source Table: relation")
    public static final Relation relation = new Relation();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.438+08:00", comments="Source field: relation.rela_id")
    public static final SqlColumn<Long> relaId = relation.relaId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.439+08:00", comments="Source field: relation.user_id_sub")
    public static final SqlColumn<Long> userIdSub = relation.userIdSub;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.439+08:00", comments="Source field: relation.user_id_pub")
    public static final SqlColumn<Long> userIdPub = relation.userIdPub;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.439+08:00", comments="Source field: relation.rela_remark")
    public static final SqlColumn<String> relaRemark = relation.relaRemark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.439+08:00", comments="Source field: relation.rela_cre_time")
    public static final SqlColumn<Date> relaCreTime = relation.relaCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.438+08:00", comments="Source Table: relation")
    public static final class Relation extends SqlTable {
        public final SqlColumn<Long> relaId = column("rela_id", JDBCType.BIGINT);

        public final SqlColumn<Long> userIdSub = column("user_id_sub", JDBCType.BIGINT);

        public final SqlColumn<Long> userIdPub = column("user_id_pub", JDBCType.BIGINT);

        public final SqlColumn<String> relaRemark = column("rela_remark", JDBCType.VARCHAR);

        public final SqlColumn<Date> relaCreTime = column("rela_cre_time", JDBCType.TIMESTAMP);

        public Relation() {
            super("relation");
        }
    }
}