package com.huston.microblog.resource.mapper;

import static com.huston.microblog.resource.mapper.ResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.resource.model.domain.Resource;
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
public interface ResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.449+08:00", comments="Source Table: resource")
    BasicColumn[] selectList = BasicColumn.columnList(resId, resUrl, resType, resUsage, resCreTime, userId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.433+08:00", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.435+08:00", comments="Source Table: resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.435+08:00", comments="Source Table: resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.resId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Resource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.439+08:00", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ResourceResult")
    Optional<Resource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.439+08:00", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ResourceResult", value = {
        @Result(column="res_id", property="resId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="res_url", property="resUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_type", property="resType", jdbcType=JdbcType.TINYINT),
        @Result(column="res_usage", property="resUsage", jdbcType=JdbcType.TINYINT),
        @Result(column="res_cre_time", property="resCreTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<Resource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.441+08:00", comments="Source Table: resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.441+08:00", comments="Source Table: resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.442+08:00", comments="Source Table: resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.443+08:00", comments="Source Table: resource")
    default int deleteByPrimaryKey(Long resId_) {
        return delete(c -> 
            c.where(resId, isEqualTo(resId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.443+08:00", comments="Source Table: resource")
    default int insert(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(resUrl).toProperty("resUrl")
            .map(resType).toProperty("resType")
            .map(resUsage).toProperty("resUsage")
            .map(resCreTime).toProperty("resCreTime")
            .map(userId).toProperty("userId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.446+08:00", comments="Source Table: resource")
    default int insertSelective(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(resUrl).toPropertyWhenPresent("resUrl", record::getResUrl)
            .map(resType).toPropertyWhenPresent("resType", record::getResType)
            .map(resUsage).toPropertyWhenPresent("resUsage", record::getResUsage)
            .map(resCreTime).toPropertyWhenPresent("resCreTime", record::getResCreTime)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.451+08:00", comments="Source Table: resource")
    default Optional<Resource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.451+08:00", comments="Source Table: resource")
    default List<Resource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.452+08:00", comments="Source Table: resource")
    default List<Resource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.453+08:00", comments="Source Table: resource")
    default Optional<Resource> selectByPrimaryKey(Long resId_) {
        return selectOne(c ->
            c.where(resId, isEqualTo(resId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.453+08:00", comments="Source Table: resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.454+08:00", comments="Source Table: resource")
    static UpdateDSL<UpdateModel> updateAllColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(resUrl).equalTo(record::getResUrl)
                .set(resType).equalTo(record::getResType)
                .set(resUsage).equalTo(record::getResUsage)
                .set(resCreTime).equalTo(record::getResCreTime)
                .set(userId).equalTo(record::getUserId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.455+08:00", comments="Source Table: resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(resUrl).equalToWhenPresent(record::getResUrl)
                .set(resType).equalToWhenPresent(record::getResType)
                .set(resUsage).equalToWhenPresent(record::getResUsage)
                .set(resCreTime).equalToWhenPresent(record::getResCreTime)
                .set(userId).equalToWhenPresent(record::getUserId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.456+08:00", comments="Source Table: resource")
    default int updateByPrimaryKey(Resource record) {
        return update(c ->
            c.set(resUrl).equalTo(record::getResUrl)
            .set(resType).equalTo(record::getResType)
            .set(resUsage).equalTo(record::getResUsage)
            .set(resCreTime).equalTo(record::getResCreTime)
            .set(userId).equalTo(record::getUserId)
            .where(resId, isEqualTo(record::getResId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-27T16:26:01.456+08:00", comments="Source Table: resource")
    default int updateByPrimaryKeySelective(Resource record) {
        return update(c ->
            c.set(resUrl).equalToWhenPresent(record::getResUrl)
            .set(resType).equalToWhenPresent(record::getResType)
            .set(resUsage).equalToWhenPresent(record::getResUsage)
            .set(resCreTime).equalToWhenPresent(record::getResCreTime)
            .set(userId).equalToWhenPresent(record::getUserId)
            .where(resId, isEqualTo(record::getResId))
        );
    }

    default Optional<Resource> selectUrlByPrimaryKey(Long resId_){
        return MyBatis3Utils.selectOne(this::selectOne, BasicColumn.columnList(resUrl), resource, c->
                c.where(resId, isEqualTo(resId_)));
    }
}