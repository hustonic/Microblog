package com.huston.microblog.comment.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AgreeCommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: agree_comment")
    public static final AgreeComment agreeComment = new AgreeComment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_id")
    public static final SqlColumn<Long> agreeId = agreeComment.agreeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.user_id")
    public static final SqlColumn<Long> userId = agreeComment.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.comm_id")
    public static final SqlColumn<Long> commId = agreeComment.commId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source field: agree_comment.agree_time")
    public static final SqlColumn<Date> agreeTime = agreeComment.agreeTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: agree_comment")
    public static final class AgreeComment extends SqlTable {
        public final SqlColumn<Long> agreeId = column("agree_id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> commId = column("comm_id", JDBCType.BIGINT);

        public final SqlColumn<Date> agreeTime = column("agree_time", JDBCType.TIMESTAMP);

        public AgreeComment() {
            super("agree_comment");
        }
    }
}