package com.huston.microblog.verification.mapper;

import static com.huston.microblog.verification.mapper.VerificationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.verification.model.domain.Verification;
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
public interface VerificationMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    BasicColumn[] selectList = BasicColumn.columnList(verId, verType, verDesc, verRealName, verIdentityCard, verState, verResDesc, verTime, userId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source Table: verification")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source Table: verification")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.956+08:00", comments="Source Table: verification")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.verId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Verification> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("VerificationResult")
    Optional<Verification> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="VerificationResult", value = {
        @Result(column="ver_id", property="verId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ver_type", property="verType", jdbcType=JdbcType.TINYINT),
        @Result(column="ver_desc", property="verDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ver_real_name", property="verRealName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ver_identity_card", property="verIdentityCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="ver_state", property="verState", jdbcType=JdbcType.TINYINT),
        @Result(column="ver_res_desc", property="verResDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ver_time", property="verTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<Verification> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, verification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, verification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    default int deleteByPrimaryKey(Long verId_) {
        return delete(c -> 
            c.where(verId, isEqualTo(verId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.966+08:00", comments="Source Table: verification")
    default int insert(Verification record) {
        return MyBatis3Utils.insert(this::insert, record, verification, c ->
            c.map(verType).toProperty("verType")
            .map(verDesc).toProperty("verDesc")
            .map(verRealName).toProperty("verRealName")
            .map(verIdentityCard).toProperty("verIdentityCard")
            .map(verState).toProperty("verState")
            .map(verResDesc).toProperty("verResDesc")
            .map(verTime).toProperty("verTime")
            .map(userId).toProperty("userId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    default int insertSelective(Verification record) {
        return MyBatis3Utils.insert(this::insert, record, verification, c ->
            c.map(verType).toPropertyWhenPresent("verType", record::getVerType)
            .map(verDesc).toPropertyWhenPresent("verDesc", record::getVerDesc)
            .map(verRealName).toPropertyWhenPresent("verRealName", record::getVerRealName)
            .map(verIdentityCard).toPropertyWhenPresent("verIdentityCard", record::getVerIdentityCard)
            .map(verState).toPropertyWhenPresent("verState", record::getVerState)
            .map(verResDesc).toPropertyWhenPresent("verResDesc", record::getVerResDesc)
            .map(verTime).toPropertyWhenPresent("verTime", record::getVerTime)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    default Optional<Verification> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, verification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    default List<Verification> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, verification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    default List<Verification> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, verification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    default Optional<Verification> selectByPrimaryKey(Long verId_) {
        return selectOne(c ->
            c.where(verId, isEqualTo(verId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, verification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.975+08:00", comments="Source Table: verification")
    static UpdateDSL<UpdateModel> updateAllColumns(Verification record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(verType).equalTo(record::getVerType)
                .set(verDesc).equalTo(record::getVerDesc)
                .set(verRealName).equalTo(record::getVerRealName)
                .set(verIdentityCard).equalTo(record::getVerIdentityCard)
                .set(verState).equalTo(record::getVerState)
                .set(verResDesc).equalTo(record::getVerResDesc)
                .set(verTime).equalTo(record::getVerTime)
                .set(userId).equalTo(record::getUserId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Verification record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(verType).equalToWhenPresent(record::getVerType)
                .set(verDesc).equalToWhenPresent(record::getVerDesc)
                .set(verRealName).equalToWhenPresent(record::getVerRealName)
                .set(verIdentityCard).equalToWhenPresent(record::getVerIdentityCard)
                .set(verState).equalToWhenPresent(record::getVerState)
                .set(verResDesc).equalToWhenPresent(record::getVerResDesc)
                .set(verTime).equalToWhenPresent(record::getVerTime)
                .set(userId).equalToWhenPresent(record::getUserId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification")
    default int updateByPrimaryKey(Verification record) {
        return update(c ->
            c.set(verType).equalTo(record::getVerType)
            .set(verDesc).equalTo(record::getVerDesc)
            .set(verRealName).equalTo(record::getVerRealName)
            .set(verIdentityCard).equalTo(record::getVerIdentityCard)
            .set(verState).equalTo(record::getVerState)
            .set(verResDesc).equalTo(record::getVerResDesc)
            .set(verTime).equalTo(record::getVerTime)
            .set(userId).equalTo(record::getUserId)
            .where(verId, isEqualTo(record::getVerId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification")
    default int updateByPrimaryKeySelective(Verification record) {
        return update(c ->
            c.set(verType).equalToWhenPresent(record::getVerType)
            .set(verDesc).equalToWhenPresent(record::getVerDesc)
            .set(verRealName).equalToWhenPresent(record::getVerRealName)
            .set(verIdentityCard).equalToWhenPresent(record::getVerIdentityCard)
            .set(verState).equalToWhenPresent(record::getVerState)
            .set(verResDesc).equalToWhenPresent(record::getVerResDesc)
            .set(verTime).equalToWhenPresent(record::getVerTime)
            .set(userId).equalToWhenPresent(record::getUserId)
            .where(verId, isEqualTo(record::getVerId))
        );
    }

    default Optional<Verification> selectByUserId(Long userId_){
        return selectOne(c->
                c.where(userId, isEqualTo(userId_)));
    }

    default List<Verification> selectByVerState(Byte verState_, Long offset, Long limit){
        return select(c->
                c.where(verState, isEqualTo(verState_))
                .limit(limit).offset(offset));
    }

    default int updateByPrimaryKeyWithConditionSelective(Verification record, Byte verState_, Long userId_){
        return update(c ->
                c.set(verType).equalToWhenPresent(record::getVerType)
                        .set(verDesc).equalToWhenPresent(record::getVerDesc)
                        .set(verRealName).equalToWhenPresent(record::getVerRealName)
                        .set(verIdentityCard).equalToWhenPresent(record::getVerIdentityCard)
                        .set(verState).equalToWhenPresent(record::getVerState)
                        .set(verResDesc).equalToWhenPresent(record::getVerResDesc)
                        .set(verTime).equalToWhenPresent(record::getVerTime)
                        .set(userId).equalToWhenPresent(record::getUserId)
                        .where(verId, isEqualTo(record::getVerId))
                        .and(verState, isEqualToWhenPresent(verState_))
                        .and(userId, isEqualToWhenPresent(userId_))
        );
    }

    default int deleteByPrimaryWithCondition(Long verId_, Long userId_){
        return delete(c ->
                c.where(verId, isEqualTo(verId_))
                .and(userId, isEqualToWhenPresent(userId_))
        );
    }
}