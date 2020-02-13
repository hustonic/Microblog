package com.huston.microblog.relation.mapper;

import static com.huston.microblog.relation.mapper.GroupDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.relation.model.domain.Group;
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
public interface GroupMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    BasicColumn[] selectList = BasicColumn.columnList(groupId, groupName, groupDesc, userId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.groupId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Group> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GroupResult")
    Optional<Group> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GroupResult", value = {
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_desc", property="groupDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<Group> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, group, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, group, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.475+08:00", comments="Source Table: group")
    default int deleteByPrimaryKey(Long groupId_) {
        return delete(c -> 
            c.where(groupId, isEqualTo(groupId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default int insert(Group record) {
        return MyBatis3Utils.insert(this::insert, record, group, c ->
            c.map(groupName).toProperty("groupName")
            .map(groupDesc).toProperty("groupDesc")
            .map(userId).toProperty("userId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default int insertSelective(Group record) {
        return MyBatis3Utils.insert(this::insert, record, group, c ->
            c.map(groupName).toPropertyWhenPresent("groupName", record::getGroupName)
            .map(groupDesc).toPropertyWhenPresent("groupDesc", record::getGroupDesc)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default Optional<Group> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, group, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default List<Group> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, group, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default List<Group> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, group, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default Optional<Group> selectByPrimaryKey(Long groupId_) {
        return selectOne(c ->
            c.where(groupId, isEqualTo(groupId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, group, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    static UpdateDSL<UpdateModel> updateAllColumns(Group record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(groupName).equalTo(record::getGroupName)
                .set(groupDesc).equalTo(record::getGroupDesc)
                .set(userId).equalTo(record::getUserId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Group record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(groupName).equalToWhenPresent(record::getGroupName)
                .set(groupDesc).equalToWhenPresent(record::getGroupDesc)
                .set(userId).equalToWhenPresent(record::getUserId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default int updateByPrimaryKey(Group record) {
        return update(c ->
            c.set(groupName).equalTo(record::getGroupName)
            .set(groupDesc).equalTo(record::getGroupDesc)
            .set(userId).equalTo(record::getUserId)
            .where(groupId, isEqualTo(record::getGroupId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-26T17:41:17.476+08:00", comments="Source Table: group")
    default int updateByPrimaryKeySelective(Group record) {
        return update(c ->
            c.set(groupName).equalToWhenPresent(record::getGroupName)
            .set(groupDesc).equalToWhenPresent(record::getGroupDesc)
            .set(userId).equalToWhenPresent(record::getUserId)
            .where(groupId, isEqualTo(record::getGroupId))
        );
    }
}