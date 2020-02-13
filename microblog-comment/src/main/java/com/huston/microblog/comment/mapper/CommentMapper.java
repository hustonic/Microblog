package com.huston.microblog.comment.mapper;

import static com.huston.microblog.comment.mapper.CommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.comment.model.domain.Comment;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    BasicColumn[] selectList = BasicColumn.columnList(commId, resId, mblogId, commIdParent, commCreTime, userId, commText);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.354+08:00", comments="Source Table: comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.354+08:00", comments="Source Table: comment")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.354+08:00", comments="Source Table: comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.commId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Comment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.354+08:00", comments="Source Table: comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommentResult")
    Optional<Comment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.354+08:00", comments="Source Table: comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommentResult", value = {
        @Result(column="comm_id", property="commId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.BIGINT),
        @Result(column="mblog_id", property="mblogId", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_id_parent", property="commIdParent", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_cre_time", property="commCreTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_text", property="commText", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Comment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default int deleteByPrimaryKey(Long commId_) {
        return delete(c -> 
            c.where(commId, isEqualTo(commId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default int insert(Comment record) {
        return MyBatis3Utils.insert(this::insert, record, comment, c ->
            c.map(resId).toProperty("resId")
            .map(mblogId).toProperty("mblogId")
            .map(commIdParent).toProperty("commIdParent")
            .map(commCreTime).toProperty("commCreTime")
            .map(userId).toProperty("userId")
            .map(commText).toProperty("commText")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default int insertSelective(Comment record) {
        return MyBatis3Utils.insert(this::insert, record, comment, c ->
            c.map(resId).toPropertyWhenPresent("resId", record::getResId)
            .map(mblogId).toPropertyWhenPresent("mblogId", record::getMblogId)
            .map(commIdParent).toPropertyWhenPresent("commIdParent", record::getCommIdParent)
            .map(commCreTime).toPropertyWhenPresent("commCreTime", record::getCommCreTime)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(commText).toPropertyWhenPresent("commText", record::getCommText)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default Optional<Comment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.364+08:00", comments="Source Table: comment")
    default List<Comment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    default List<Comment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    default Optional<Comment> selectByPrimaryKey(Long commId_) {
        return selectOne(c ->
            c.where(commId, isEqualTo(commId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    static UpdateDSL<UpdateModel> updateAllColumns(Comment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(resId).equalTo(record::getResId)
                .set(mblogId).equalTo(record::getMblogId)
                .set(commIdParent).equalTo(record::getCommIdParent)
                .set(commCreTime).equalTo(record::getCommCreTime)
                .set(userId).equalTo(record::getUserId)
                .set(commText).equalTo(record::getCommText);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Comment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(resId).equalToWhenPresent(record::getResId)
                .set(mblogId).equalToWhenPresent(record::getMblogId)
                .set(commIdParent).equalToWhenPresent(record::getCommIdParent)
                .set(commCreTime).equalToWhenPresent(record::getCommCreTime)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(commText).equalToWhenPresent(record::getCommText);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    default int updateByPrimaryKey(Comment record) {
        return update(c ->
            c.set(resId).equalTo(record::getResId)
            .set(mblogId).equalTo(record::getMblogId)
            .set(commIdParent).equalTo(record::getCommIdParent)
            .set(commCreTime).equalTo(record::getCommCreTime)
            .set(userId).equalTo(record::getUserId)
            .set(commText).equalTo(record::getCommText)
            .where(commId, isEqualTo(record::getCommId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: comment")
    default int updateByPrimaryKeySelective(Comment record) {
        return update(c ->
            c.set(resId).equalToWhenPresent(record::getResId)
            .set(mblogId).equalToWhenPresent(record::getMblogId)
            .set(commIdParent).equalToWhenPresent(record::getCommIdParent)
            .set(commCreTime).equalToWhenPresent(record::getCommCreTime)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(commText).equalToWhenPresent(record::getCommText)
            .where(commId, isEqualTo(record::getCommId))
        );
    }

    default int deleteByCommIdAndUserId(Long commId_, Long userId_){
        return delete(c->
                c.where(commId, isEqualTo(commId_))
                .and(userId, isEqualTo(userId_)));
    }

    //查询子评论列表
    default List<Comment> selectByMblogIdAndCommIdParent(Long mblogId_, Long commIdParent_, Long offset, Long limit){
        return select(c->
                c.where(mblogId, isEqualTo(mblogId_))
                .and(commIdParent, isEqualTo(commIdParent_))
                .orderBy(commCreTime.descending())
                .limit(limit).offset(offset));
    }

    //查询微博评论列表
    default List<Comment> selectByMblogIdAndCommIdParentIsNull(Long mblogId_, Long offset, Long limit){
        return select(c->
                c.where(mblogId, isEqualTo(mblogId_))
                .and(commIdParent, isNull())
                .orderBy(commCreTime.descending())
                .limit(limit).offset(offset));
    }

    default Long countComment(Long mblogId_, Long commId_){
        return count(c->
                c.where(mblogId, isEqualTo(mblogId_))
                .and(commIdParent, isEqualToWhenPresent(commId_)));
    }

    default Long countCommentWhenCommIdParentIsNull(Long mblogId_){
        return count(c->
                c.where(mblogId, isEqualTo(mblogId_))
                .and(commIdParent, isNull()));
    }
}