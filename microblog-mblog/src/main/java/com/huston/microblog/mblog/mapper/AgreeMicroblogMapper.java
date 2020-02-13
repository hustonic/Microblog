package com.huston.microblog.mblog.mapper;

import static com.huston.microblog.mblog.mapper.AgreeMicroblogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.mblog.model.domain.AgreeMicroblog;
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
public interface AgreeMicroblogMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    BasicColumn[] selectList = BasicColumn.columnList(agreeId, userId, mblogId, agreeTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source Table: agree_microblog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source Table: agree_microblog")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source Table: agree_microblog")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.agreeId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<AgreeMicroblog> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.646+08:00", comments="Source Table: agree_microblog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AgreeMicroblogResult")
    Optional<AgreeMicroblog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AgreeMicroblogResult", value = {
        @Result(column="agree_id", property="agreeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="mblog_id", property="mblogId", jdbcType=JdbcType.BIGINT),
        @Result(column="agree_time", property="agreeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AgreeMicroblog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, agreeMicroblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, agreeMicroblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default int deleteByPrimaryKey(Long agreeId_) {
        return delete(c -> 
            c.where(agreeId, isEqualTo(agreeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default int insert(AgreeMicroblog record) {
        return MyBatis3Utils.insert(this::insert, record, agreeMicroblog, c ->
            c.map(userId).toProperty("userId")
            .map(mblogId).toProperty("mblogId")
            .map(agreeTime).toProperty("agreeTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default int insertSelective(AgreeMicroblog record) {
        return MyBatis3Utils.insert(this::insert, record, agreeMicroblog, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(mblogId).toPropertyWhenPresent("mblogId", record::getMblogId)
            .map(agreeTime).toPropertyWhenPresent("agreeTime", record::getAgreeTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default Optional<AgreeMicroblog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, agreeMicroblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default List<AgreeMicroblog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, agreeMicroblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default List<AgreeMicroblog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, agreeMicroblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default Optional<AgreeMicroblog> selectByPrimaryKey(Long agreeId_) {
        return selectOne(c ->
            c.where(agreeId, isEqualTo(agreeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, agreeMicroblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.647+08:00", comments="Source Table: agree_microblog")
    static UpdateDSL<UpdateModel> updateAllColumns(AgreeMicroblog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(mblogId).equalTo(record::getMblogId)
                .set(agreeTime).equalTo(record::getAgreeTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.648+08:00", comments="Source Table: agree_microblog")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AgreeMicroblog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(mblogId).equalToWhenPresent(record::getMblogId)
                .set(agreeTime).equalToWhenPresent(record::getAgreeTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.648+08:00", comments="Source Table: agree_microblog")
    default int updateByPrimaryKey(AgreeMicroblog record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(mblogId).equalTo(record::getMblogId)
            .set(agreeTime).equalTo(record::getAgreeTime)
            .where(agreeId, isEqualTo(record::getAgreeId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.648+08:00", comments="Source Table: agree_microblog")
    default int updateByPrimaryKeySelective(AgreeMicroblog record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(mblogId).equalToWhenPresent(record::getMblogId)
            .set(agreeTime).equalToWhenPresent(record::getAgreeTime)
            .where(agreeId, isEqualTo(record::getAgreeId))
        );
    }

    default List<AgreeMicroblog> selectByUserId(Long userId_, Long offset, Long limit){
        return select(c->
                c.where(userId, isEqualTo(userId_))
                .limit(limit).offset(offset));
    }

    default List<AgreeMicroblog> selectByMblogId(Long mblogId_, Long offset, Long limit){
        return select(c->
                c.where(mblogId, isEqualTo(mblogId_))
                .limit(limit).offset(offset));
    }

    default List<AgreeMicroblog> selectByUserIdMblogId(Long userId_, Long mblogId_){
        return select(c->
                c.where(userId, isEqualTo(userId_))
                .and(mblogId, isEqualTo(mblogId_)));
    }

    default Long countByMblogId(Long mblogId_){
        return count(c->
                c.where(mblogId, isEqualTo(mblogId_)));
    }
}