package com.huston.microblog.mblog.mapper;

import static com.huston.microblog.mblog.mapper.MicroblogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.mblog.model.domain.Microblog;
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
public interface MicroblogMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.632+08:00", comments="Source Table: microblog")
    BasicColumn[] selectList = BasicColumn.columnList(mblogId, mblogType, mblogIdForward, mblogPubTime, userId, mblogText);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.617+08:00", comments="Source Table: microblog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.619+08:00", comments="Source Table: microblog")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.619+08:00", comments="Source Table: microblog")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.mblogId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Microblog> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.623+08:00", comments="Source Table: microblog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MicroblogResult")
    Optional<Microblog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.624+08:00", comments="Source Table: microblog")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MicroblogResult", value = {
        @Result(column="mblog_id", property="mblogId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mblog_type", property="mblogType", jdbcType=JdbcType.TINYINT),
        @Result(column="mblog_id_forward", property="mblogIdForward", jdbcType=JdbcType.BIGINT),
        @Result(column="mblog_pub_time", property="mblogPubTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="mblog_text", property="mblogText", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Microblog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.625+08:00", comments="Source Table: microblog")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.626+08:00", comments="Source Table: microblog")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, microblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.626+08:00", comments="Source Table: microblog")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, microblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.627+08:00", comments="Source Table: microblog")
    default int deleteByPrimaryKey(Long mblogId_) {
        return delete(c -> 
            c.where(mblogId, isEqualTo(mblogId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.628+08:00", comments="Source Table: microblog")
    default int insert(Microblog record) {
        return MyBatis3Utils.insert(this::insert, record, microblog, c ->
            c.map(mblogType).toProperty("mblogType")
            .map(mblogIdForward).toProperty("mblogIdForward")
            .map(mblogPubTime).toProperty("mblogPubTime")
            .map(userId).toProperty("userId")
            .map(mblogText).toProperty("mblogText")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.63+08:00", comments="Source Table: microblog")
    default int insertSelective(Microblog record) {
        return MyBatis3Utils.insert(this::insert, record, microblog, c ->
            c.map(mblogType).toPropertyWhenPresent("mblogType", record::getMblogType)
            .map(mblogIdForward).toPropertyWhenPresent("mblogIdForward", record::getMblogIdForward)
            .map(mblogPubTime).toPropertyWhenPresent("mblogPubTime", record::getMblogPubTime)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(mblogText).toPropertyWhenPresent("mblogText", record::getMblogText)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.635+08:00", comments="Source Table: microblog")
    default Optional<Microblog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, microblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.636+08:00", comments="Source Table: microblog")
    default List<Microblog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, microblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.637+08:00", comments="Source Table: microblog")
    default List<Microblog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, microblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.637+08:00", comments="Source Table: microblog")
    default Optional<Microblog> selectByPrimaryKey(Long mblogId_) {
        return selectOne(c ->
            c.where(mblogId, isEqualTo(mblogId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.638+08:00", comments="Source Table: microblog")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, microblog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.639+08:00", comments="Source Table: microblog")
    static UpdateDSL<UpdateModel> updateAllColumns(Microblog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mblogType).equalTo(record::getMblogType)
                .set(mblogIdForward).equalTo(record::getMblogIdForward)
                .set(mblogPubTime).equalTo(record::getMblogPubTime)
                .set(userId).equalTo(record::getUserId)
                .set(mblogText).equalTo(record::getMblogText);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.639+08:00", comments="Source Table: microblog")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Microblog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mblogType).equalToWhenPresent(record::getMblogType)
                .set(mblogIdForward).equalToWhenPresent(record::getMblogIdForward)
                .set(mblogPubTime).equalToWhenPresent(record::getMblogPubTime)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(mblogText).equalToWhenPresent(record::getMblogText);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.64+08:00", comments="Source Table: microblog")
    default int updateByPrimaryKey(Microblog record) {
        return update(c ->
            c.set(mblogType).equalTo(record::getMblogType)
            .set(mblogIdForward).equalTo(record::getMblogIdForward)
            .set(mblogPubTime).equalTo(record::getMblogPubTime)
            .set(userId).equalTo(record::getUserId)
            .set(mblogText).equalTo(record::getMblogText)
            .where(mblogId, isEqualTo(record::getMblogId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.641+08:00", comments="Source Table: microblog")
    default int updateByPrimaryKeySelective(Microblog record) {
        return update(c ->
            c.set(mblogType).equalToWhenPresent(record::getMblogType)
            .set(mblogIdForward).equalToWhenPresent(record::getMblogIdForward)
            .set(mblogPubTime).equalToWhenPresent(record::getMblogPubTime)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(mblogText).equalToWhenPresent(record::getMblogText)
            .where(mblogId, isEqualTo(record::getMblogId))
        );
    }

    default Long countByMblogIdForward(Long mblogIdForward_){
        return count(c->
                c.where(mblogIdForward, isEqualTo(mblogIdForward_)));
    }
}