package com.huston.microblog.mblog.mapper;

import static com.huston.microblog.mblog.mapper.MicroblogResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.mblog.model.domain.MicroblogResource;
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
public interface MicroblogResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    BasicColumn[] selectList = BasicColumn.columnList(mblogResId, mblogId, resId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source Table: microblog_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source Table: microblog_resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.655+08:00", comments="Source Table: microblog_resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.mblogResId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<MicroblogResource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MicroblogResourceResult")
    Optional<MicroblogResource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MicroblogResourceResult", value = {
        @Result(column="mblog_res_id", property="mblogResId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mblog_id", property="mblogId", jdbcType=JdbcType.BIGINT),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.BIGINT)
    })
    List<MicroblogResource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, microblogResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, microblogResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default int deleteByPrimaryKey(Long mblogResId_) {
        return delete(c -> 
            c.where(mblogResId, isEqualTo(mblogResId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default int insert(MicroblogResource record) {
        return MyBatis3Utils.insert(this::insert, record, microblogResource, c ->
            c.map(mblogId).toProperty("mblogId")
            .map(resId).toProperty("resId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default int insertSelective(MicroblogResource record) {
        return MyBatis3Utils.insert(this::insert, record, microblogResource, c ->
            c.map(mblogId).toPropertyWhenPresent("mblogId", record::getMblogId)
            .map(resId).toPropertyWhenPresent("resId", record::getResId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default Optional<MicroblogResource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, microblogResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default List<MicroblogResource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, microblogResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default List<MicroblogResource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, microblogResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default Optional<MicroblogResource> selectByPrimaryKey(Long mblogResId_) {
        return selectOne(c ->
            c.where(mblogResId, isEqualTo(mblogResId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.656+08:00", comments="Source Table: microblog_resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, microblogResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.657+08:00", comments="Source Table: microblog_resource")
    static UpdateDSL<UpdateModel> updateAllColumns(MicroblogResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mblogId).equalTo(record::getMblogId)
                .set(resId).equalTo(record::getResId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.657+08:00", comments="Source Table: microblog_resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MicroblogResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mblogId).equalToWhenPresent(record::getMblogId)
                .set(resId).equalToWhenPresent(record::getResId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.657+08:00", comments="Source Table: microblog_resource")
    default int updateByPrimaryKey(MicroblogResource record) {
        return update(c ->
            c.set(mblogId).equalTo(record::getMblogId)
            .set(resId).equalTo(record::getResId)
            .where(mblogResId, isEqualTo(record::getMblogResId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:16:01.657+08:00", comments="Source Table: microblog_resource")
    default int updateByPrimaryKeySelective(MicroblogResource record) {
        return update(c ->
            c.set(mblogId).equalToWhenPresent(record::getMblogId)
            .set(resId).equalToWhenPresent(record::getResId)
            .where(mblogResId, isEqualTo(record::getMblogResId))
        );
    }

    default List<MicroblogResource> selectByMblogId(Long mblogId_){
        return select(c->
                c.where(mblogId, isEqualTo(mblogId_)));
    }

}