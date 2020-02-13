package com.huston.microblog.relation.mapper;

import static com.huston.microblog.relation.mapper.RelationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.relation.model.domain.Relation;
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
public interface RelationMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.46+08:00", comments="Source Table: relation")
    BasicColumn[] selectList = BasicColumn.columnList(relaId, userIdSub, userIdPub, relaRemark, relaCreTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.441+08:00", comments="Source Table: relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.444+08:00", comments="Source Table: relation")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.444+08:00", comments="Source Table: relation")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.relaId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Relation> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.45+08:00", comments="Source Table: relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RelationResult")
    Optional<Relation> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.451+08:00", comments="Source Table: relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RelationResult", value = {
        @Result(column="rela_id", property="relaId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id_sub", property="userIdSub", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id_pub", property="userIdPub", jdbcType=JdbcType.BIGINT),
        @Result(column="rela_remark", property="relaRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="rela_cre_time", property="relaCreTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Relation> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.452+08:00", comments="Source Table: relation")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.453+08:00", comments="Source Table: relation")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, relation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.454+08:00", comments="Source Table: relation")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, relation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.454+08:00", comments="Source Table: relation")
    default int deleteByPrimaryKey(Long relaId_) {
        return delete(c -> 
            c.where(relaId, isEqualTo(relaId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.455+08:00", comments="Source Table: relation")
    default int insert(Relation record) {
        return MyBatis3Utils.insert(this::insert, record, relation, c ->
            c.map(userIdSub).toProperty("userIdSub")
            .map(userIdPub).toProperty("userIdPub")
            .map(relaRemark).toProperty("relaRemark")
            .map(relaCreTime).toProperty("relaCreTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.458+08:00", comments="Source Table: relation")
    default int insertSelective(Relation record) {
        return MyBatis3Utils.insert(this::insert, record, relation, c ->
            c.map(userIdSub).toPropertyWhenPresent("userIdSub", record::getUserIdSub)
            .map(userIdPub).toPropertyWhenPresent("userIdPub", record::getUserIdPub)
            .map(relaRemark).toPropertyWhenPresent("relaRemark", record::getRelaRemark)
            .map(relaCreTime).toPropertyWhenPresent("relaCreTime", record::getRelaCreTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.462+08:00", comments="Source Table: relation")
    default Optional<Relation> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, relation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.463+08:00", comments="Source Table: relation")
    default List<Relation> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, relation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.464+08:00", comments="Source Table: relation")
    default List<Relation> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, relation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.465+08:00", comments="Source Table: relation")
    default Optional<Relation> selectByPrimaryKey(Long relaId_) {
        return selectOne(c ->
            c.where(relaId, isEqualTo(relaId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.466+08:00", comments="Source Table: relation")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, relation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.467+08:00", comments="Source Table: relation")
    static UpdateDSL<UpdateModel> updateAllColumns(Relation record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userIdSub).equalTo(record::getUserIdSub)
                .set(userIdPub).equalTo(record::getUserIdPub)
                .set(relaRemark).equalTo(record::getRelaRemark)
                .set(relaCreTime).equalTo(record::getRelaCreTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.468+08:00", comments="Source Table: relation")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Relation record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userIdSub).equalToWhenPresent(record::getUserIdSub)
                .set(userIdPub).equalToWhenPresent(record::getUserIdPub)
                .set(relaRemark).equalToWhenPresent(record::getRelaRemark)
                .set(relaCreTime).equalToWhenPresent(record::getRelaCreTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.469+08:00", comments="Source Table: relation")
    default int updateByPrimaryKey(Relation record) {
        return update(c ->
            c.set(userIdSub).equalTo(record::getUserIdSub)
            .set(userIdPub).equalTo(record::getUserIdPub)
            .set(relaRemark).equalTo(record::getRelaRemark)
            .set(relaCreTime).equalTo(record::getRelaCreTime)
            .where(relaId, isEqualTo(record::getRelaId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.47+08:00", comments="Source Table: relation")
    default int updateByPrimaryKeySelective(Relation record) {
        return update(c ->
            c.set(userIdSub).equalToWhenPresent(record::getUserIdSub)
            .set(userIdPub).equalToWhenPresent(record::getUserIdPub)
            .set(relaRemark).equalToWhenPresent(record::getRelaRemark)
            .set(relaCreTime).equalToWhenPresent(record::getRelaCreTime)
            .where(relaId, isEqualTo(record::getRelaId))
        );
    }

    default List<Relation> selectByUserIdSub(Long userIdSub_, Long offset, Long limit){
        return select(c->
                c.where(userIdSub, isEqualTo(userIdSub_))
                .limit(limit).offset(offset));
    }

    default List<Relation> selectByUserIdPub(Long userIdPub_, Long offset, Long limit){
        return select(c->
                c.where(userIdPub, isEqualTo(userIdPub_))
                        .limit(limit).offset(offset));
    }

    default List<Relation> selectUserIdSubByUserIdPub(Long userIdPub_){
        return MyBatis3Utils.selectList(this::selectMany, BasicColumn.columnList(userIdSub), relation, c->
                c.where(userIdPub, isEqualTo(userIdPub_)));
    }

    default Long countRelation(Long userIdSub_, Long userIdPub_){
        return count(c->
                c.where(userIdSub, isEqualToWhenPresent(userIdSub_))
                .and(userIdPub, isEqualToWhenPresent(userIdPub_)));
    }
}