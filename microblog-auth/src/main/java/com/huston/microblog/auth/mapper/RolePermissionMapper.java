package com.huston.microblog.auth.mapper;

import static com.huston.microblog.auth.mapper.RolePermissionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.auth.model.domain.RolePermission;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
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

@Mapper
public interface RolePermissionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    BasicColumn[] selectList = BasicColumn.columnList(rolePermId, roleId, permId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.023+08:00", comments="Source Table: role_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RolePermission> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RolePermissionResult")
    Optional<RolePermission> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RolePermissionResult", value = {
        @Result(column="role_perm_id", property="rolePermId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.BIGINT)
    })
    List<RolePermission> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, rolePermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, rolePermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    default int deleteByPrimaryKey(Long rolePermId_) {
        return delete(c -> 
            c.where(rolePermId, isEqualTo(rolePermId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    default int insert(RolePermission record) {
        return MyBatis3Utils.insert(this::insert, record, rolePermission, c ->
            c.map(rolePermId).toProperty("rolePermId")
            .map(roleId).toProperty("roleId")
            .map(permId).toProperty("permId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    default int insertSelective(RolePermission record) {
        return MyBatis3Utils.insert(this::insert, record, rolePermission, c ->
            c.map(rolePermId).toPropertyWhenPresent("rolePermId", record::getRolePermId)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(permId).toPropertyWhenPresent("permId", record::getPermId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.024+08:00", comments="Source Table: role_permission")
    default Optional<RolePermission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, rolePermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    default List<RolePermission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, rolePermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    default List<RolePermission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, rolePermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    default Optional<RolePermission> selectByPrimaryKey(Long rolePermId_) {
        return selectOne(c ->
            c.where(rolePermId, isEqualTo(rolePermId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, rolePermission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    static UpdateDSL<UpdateModel> updateAllColumns(RolePermission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(rolePermId).equalTo(record::getRolePermId)
                .set(roleId).equalTo(record::getRoleId)
                .set(permId).equalTo(record::getPermId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RolePermission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(rolePermId).equalToWhenPresent(record::getRolePermId)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(permId).equalToWhenPresent(record::getPermId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    default int updateByPrimaryKey(RolePermission record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(permId).equalTo(record::getPermId)
            .where(rolePermId, isEqualTo(record::getRolePermId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.025+08:00", comments="Source Table: role_permission")
    default int updateByPrimaryKeySelective(RolePermission record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(permId).equalToWhenPresent(record::getPermId)
            .where(rolePermId, isEqualTo(record::getRolePermId))
        );
    }
}