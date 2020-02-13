package com.huston.microblog.comment.mapper;

import static com.huston.microblog.comment.mapper.AgreeCommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.comment.model.domain.AgreeComment;
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
public interface AgreeCommentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    BasicColumn[] selectList = BasicColumn.columnList(agreeId, userId, commId, agreeTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: agree_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: agree_comment")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.374+08:00", comments="Source Table: agree_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.agreeId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<AgreeComment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AgreeCommentResult")
    Optional<AgreeComment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AgreeCommentResult", value = {
        @Result(column="agree_id", property="agreeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_id", property="commId", jdbcType=JdbcType.BIGINT),
        @Result(column="agree_time", property="agreeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AgreeComment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, agreeComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, agreeComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int deleteByPrimaryKey(Long agreeId_) {
        return delete(c -> 
            c.where(agreeId, isEqualTo(agreeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int insert(AgreeComment record) {
        return MyBatis3Utils.insert(this::insert, record, agreeComment, c ->
            c.map(userId).toProperty("userId")
            .map(commId).toProperty("commId")
            .map(agreeTime).toProperty("agreeTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int insertSelective(AgreeComment record) {
        return MyBatis3Utils.insert(this::insert, record, agreeComment, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(commId).toPropertyWhenPresent("commId", record::getCommId)
            .map(agreeTime).toPropertyWhenPresent("agreeTime", record::getAgreeTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default Optional<AgreeComment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, agreeComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default List<AgreeComment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, agreeComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default List<AgreeComment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, agreeComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default Optional<AgreeComment> selectByPrimaryKey(Long agreeId_) {
        return selectOne(c ->
            c.where(agreeId, isEqualTo(agreeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, agreeComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    static UpdateDSL<UpdateModel> updateAllColumns(AgreeComment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(commId).equalTo(record::getCommId)
                .set(agreeTime).equalTo(record::getAgreeTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AgreeComment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(commId).equalToWhenPresent(record::getCommId)
                .set(agreeTime).equalToWhenPresent(record::getAgreeTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int updateByPrimaryKey(AgreeComment record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(commId).equalTo(record::getCommId)
            .set(agreeTime).equalTo(record::getAgreeTime)
            .where(agreeId, isEqualTo(record::getAgreeId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-01-28T18:48:31.384+08:00", comments="Source Table: agree_comment")
    default int updateByPrimaryKeySelective(AgreeComment record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(commId).equalToWhenPresent(record::getCommId)
            .set(agreeTime).equalToWhenPresent(record::getAgreeTime)
            .where(agreeId, isEqualTo(record::getAgreeId))
        );
    }

    default int deleteByAgreeIdAndUserId(Long agreeId_, Long userId_){
        return delete(c->
                c.where(agreeId, isEqualTo(agreeId_))
                .and(userId, isEqualTo(userId_)));
    }

    default List<AgreeComment> selectByUserIdAndCommIdWhenPresent(Long userId_, Long commId_, Long offset, Long limit){
        return select(c -> c
                .where(userId, isEqualToWhenPresent(userId_))
                .and(commId, isEqualToWhenPresent(commId_))
                .limit(limit).offset(offset));
    }

    default Long countByCommId(Long commId_){
        return count(c -> c.where(commId, isEqualTo(commId_)));
    }
}