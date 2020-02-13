package com.huston.microblog.relation.mapper;

import static com.huston.microblog.relation.mapper.RelationGroupDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.relation.model.domain.RelationGroup;
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
public interface RelationGroupMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    BasicColumn[] selectList = BasicColumn.columnList(relaGrpId, relaId, groupId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.478+08:00", comments="Source Table: relation_group")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.478+08:00", comments="Source Table: relation_group")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.relaGrpId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<RelationGroup> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RelationGroupResult")
    Optional<RelationGroup> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RelationGroupResult", value = {
        @Result(column="rela_grp_id", property="relaGrpId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="rela_id", property="relaId", jdbcType=JdbcType.BIGINT),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.BIGINT)
    })
    List<RelationGroup> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, relationGroup, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, relationGroup, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    default int deleteByPrimaryKey(Long relaGrpId_) {
        return delete(c -> 
            c.where(relaGrpId, isEqualTo(relaGrpId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.479+08:00", comments="Source Table: relation_group")
    default int insert(RelationGroup record) {
        return MyBatis3Utils.insert(this::insert, record, relationGroup, c ->
            c.map(relaId).toProperty("relaId")
            .map(groupId).toProperty("groupId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default int insertSelective(RelationGroup record) {
        return MyBatis3Utils.insert(this::insert, record, relationGroup, c ->
            c.map(relaId).toPropertyWhenPresent("relaId", record::getRelaId)
            .map(groupId).toPropertyWhenPresent("groupId", record::getGroupId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default Optional<RelationGroup> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, relationGroup, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default List<RelationGroup> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, relationGroup, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default List<RelationGroup> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, relationGroup, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default Optional<RelationGroup> selectByPrimaryKey(Long relaGrpId_) {
        return selectOne(c ->
            c.where(relaGrpId, isEqualTo(relaGrpId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, relationGroup, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    static UpdateDSL<UpdateModel> updateAllColumns(RelationGroup record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(relaId).equalTo(record::getRelaId)
                .set(groupId).equalTo(record::getGroupId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RelationGroup record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(relaId).equalToWhenPresent(record::getRelaId)
                .set(groupId).equalToWhenPresent(record::getGroupId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.48+08:00", comments="Source Table: relation_group")
    default int updateByPrimaryKey(RelationGroup record) {
        return update(c ->
            c.set(relaId).equalTo(record::getRelaId)
            .set(groupId).equalTo(record::getGroupId)
            .where(relaGrpId, isEqualTo(record::getRelaGrpId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.481+08:00", comments="Source Table: relation_group")
    default int updateByPrimaryKeySelective(RelationGroup record) {
        return update(c ->
            c.set(relaId).equalToWhenPresent(record::getRelaId)
            .set(groupId).equalToWhenPresent(record::getGroupId)
            .where(relaGrpId, isEqualTo(record::getRelaGrpId))
        );
    }

    default int deleteByRelaId(Long relaId_){
        return delete(c->
                c.where(relaId, isEqualTo(relaId_)));
    }
}