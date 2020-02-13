package com.huston.microblog.comment.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source Table: comment")
    public static final Comment comment = new Comment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.comm_id")
    public static final SqlColumn<Long> commId = comment.commId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.res_id")
    public static final SqlColumn<Long> resId = comment.resId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.mblog_id")
    public static final SqlColumn<Long> mblogId = comment.mblogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.comm_id_parent")
    public static final SqlColumn<Long> commIdParent = comment.commIdParent;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.comm_cre_time")
    public static final SqlColumn<Date> commCreTime = comment.commCreTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.user_id")
    public static final SqlColumn<Long> userId = comment.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source field: comment.comm_text")
    public static final SqlColumn<String> commText = comment.commText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.344+08:00", comments="Source Table: comment")
    public static final class Comment extends SqlTable {
        public final SqlColumn<Long> commId = column("comm_id", JDBCType.BIGINT);

        public final SqlColumn<Long> resId = column("res_id", JDBCType.BIGINT);

        public final SqlColumn<Long> mblogId = column("mblog_id", JDBCType.BIGINT);

        public final SqlColumn<Long> commIdParent = column("comm_id_parent", JDBCType.BIGINT);

        public final SqlColumn<Date> commCreTime = column("comm_cre_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> commText = column("comm_text", JDBCType.LONGVARCHAR);

        public Comment() {
            super("comment");
        }
    }
}