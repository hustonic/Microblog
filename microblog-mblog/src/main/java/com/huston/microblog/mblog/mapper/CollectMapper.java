package com.huston.microblog.mblog.mapper;

import static com.huston.microblog.mblog.mapper.CollectDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.mblog.model.domain.Collect;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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
public interface CollectMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    BasicColumn[] selectList = BasicColumn.columnList(collectId, userId, mblogId, collectTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.651+08:00", comments="Source Table: collect")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.651+08:00", comments="Source Table: collect")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.collectId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Collect> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CollectResult")
    Optional<Collect> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CollectResult", value = {
        @Result(column="collect_id", property="collectId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="mblog_id", property="mblogId", jdbcType=JdbcType.BIGINT),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Collect> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, collect, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, collect, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    default int deleteByPrimaryKey(Long collectId_) {
        return delete(c -> 
            c.where(collectId, isEqualTo(collectId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.652+08:00", comments="Source Table: collect")
    default int insert(Collect record) {
        return MyBatis3Utils.insert(this::insert, record, collect, c ->
            c.map(userId).toProperty("userId")
            .map(mblogId).toProperty("mblogId")
            .map(collectTime).toProperty("collectTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default int insertSelective(Collect record) {
        return MyBatis3Utils.insert(this::insert, record, collect, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(mblogId).toPropertyWhenPresent("mblogId", record::getMblogId)
            .map(collectTime).toPropertyWhenPresent("collectTime", record::getCollectTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default Optional<Collect> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, collect, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default List<Collect> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, collect, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default List<Collect> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, collect, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default Optional<Collect> selectByPrimaryKey(Long collectId_) {
        return selectOne(c ->
            c.where(collectId, isEqualTo(collectId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, collect, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    static UpdateDSL<UpdateModel> updateAllColumns(Collect record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(mblogId).equalTo(record::getMblogId)
                .set(collectTime).equalTo(record::getCollectTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Collect record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(mblogId).equalToWhenPresent(record::getMblogId)
                .set(collectTime).equalToWhenPresent(record::getCollectTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default int updateByPrimaryKey(Collect record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(mblogId).equalTo(record::getMblogId)
            .set(collectTime).equalTo(record::getCollectTime)
            .where(collectId, isEqualTo(record::getCollectId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.653+08:00", comments="Source Table: collect")
    default int updateByPrimaryKeySelective(Collect record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(mblogId).equalToWhenPresent(record::getMblogId)
            .set(collectTime).equalToWhenPresent(record::getCollectTime)
            .where(collectId, isEqualTo(record::getCollectId))
        );
    }

    default List<Collect> selectByUserId(Long userId_, Long offset, Long limit){
        return select(c->
                c.where(userId, isEqualTo(userId_))
                .limit(limit).offset(offset));
    }

    default Optional<Collect> selectByUserIdAndMblogId(Long userId_, Long mblogId_){
        return selectOne(c->
                c.where(userId, isEqualTo(userId_))
                .and(mblogId, isEqualTo(mblogId_)));
    }
}