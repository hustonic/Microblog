package com.huston.microblog.auth.mapper;

import static com.huston.microblog.auth.mapper.RoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.auth.model.domain.Role;
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
public interface RoleMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.021+08:00", comments="Source Table: role")
    BasicColumn[] selectList = BasicColumn.columnList(roleId, roleName, roleDesc, roleCreTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.roleId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Role> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoleResult")
    Optional<Role> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoleResult", value = {
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_desc", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_cre_time", property="roleCreTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Role> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.02+08:00", comments="Source Table: role")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.021+08:00", comments="Source Table: role")
    default int deleteByPrimaryKey(Long roleId_) {
        return delete(c -> 
            c.where(roleId, isEqualTo(roleId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.021+08:00", comments="Source Table: role")
    default int insert(Role record) {
        return MyBatis3Utils.insert(this::insert, record, role, c ->
            c.map(roleName).toProperty("roleName")
            .map(roleDesc).toProperty("roleDesc")
            .map(roleCreTime).toProperty("roleCreTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.021+08:00", comments="Source Table: role")
    default int insertSelective(Role record) {
        return MyBatis3Utils.insert(this::insert, record, role, c ->
            c.map(roleName).toPropertyWhenPresent("roleName", record::getRoleName)
            .map(roleDesc).toPropertyWhenPresent("roleDesc", record::getRoleDesc)
            .map(roleCreTime).toPropertyWhenPresent("roleCreTime", record::getRoleCreTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.021+08:00", comments="Source Table: role")
    default Optional<Role> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    default List<Role> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    default List<Role> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    default Optional<Role> selectByPrimaryKey(Long roleId_) {
        return selectOne(c ->
            c.where(roleId, isEqualTo(roleId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, role, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    static UpdateDSL<UpdateModel> updateAllColumns(Role record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleName).equalTo(record::getRoleName)
                .set(roleDesc).equalTo(record::getRoleDesc)
                .set(roleCreTime).equalTo(record::getRoleCreTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Role record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleName).equalToWhenPresent(record::getRoleName)
                .set(roleDesc).equalToWhenPresent(record::getRoleDesc)
                .set(roleCreTime).equalToWhenPresent(record::getRoleCreTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    default int updateByPrimaryKey(Role record) {
        return update(c ->
            c.set(roleName).equalTo(record::getRoleName)
            .set(roleDesc).equalTo(record::getRoleDesc)
            .set(roleCreTime).equalTo(record::getRoleCreTime)
            .where(roleId, isEqualTo(record::getRoleId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.022+08:00", comments="Source Table: role")
    default int updateByPrimaryKeySelective(Role record) {
        return update(c ->
            c.set(roleName).equalToWhenPresent(record::getRoleName)
            .set(roleDesc).equalToWhenPresent(record::getRoleDesc)
            .set(roleCreTime).equalToWhenPresent(record::getRoleCreTime)
            .where(roleId, isEqualTo(record::getRoleId))
        );
    }

    default Optional<Role> selectByRoleName(String roleName_){
        return selectOne(c->
                c.where(roleName,isEqualTo(roleName_)));
    }
}