package com.huston.microblog.auth.mapper;

import static com.huston.microblog.auth.mapper.PermissionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.auth.model.domain.Permission;
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
public interface PermissionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    BasicColumn[] selectList = BasicColumn.columnList(permId, permName, permDesc, permUrl, permCreTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source Table: permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source Table: permission")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source Table: permission")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Permission> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source Table: permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PermissionResult")
    Optional<Permission> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.027+08:00", comments="Source Table: permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PermissionResult", value = {
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="perm_name", property="permName", jdbcType=JdbcType.VARCHAR),
        @Result(column="perm_desc", property="permDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="perm_url", property="permUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="perm_cre_time", property="permCreTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Permission> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default int deleteByPrimaryKey(Long permId_) {
        return delete(c -> 
            c.where(permId, isEqualTo(permId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default int insert(Permission record) {
        return MyBatis3Utils.insert(this::insert, record, permission, c ->
            c.map(permId).toProperty("permId")
            .map(permName).toProperty("permName")
            .map(permDesc).toProperty("permDesc")
            .map(permUrl).toProperty("permUrl")
            .map(permCreTime).toProperty("permCreTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default int insertSelective(Permission record) {
        return MyBatis3Utils.insert(this::insert, record, permission, c ->
            c.map(permId).toPropertyWhenPresent("permId", record::getPermId)
            .map(permName).toPropertyWhenPresent("permName", record::getPermName)
            .map(permDesc).toPropertyWhenPresent("permDesc", record::getPermDesc)
            .map(permUrl).toPropertyWhenPresent("permUrl", record::getPermUrl)
            .map(permCreTime).toPropertyWhenPresent("permCreTime", record::getPermCreTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default Optional<Permission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default List<Permission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default List<Permission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default Optional<Permission> selectByPrimaryKey(Long permId_) {
        return selectOne(c ->
            c.where(permId, isEqualTo(permId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    static UpdateDSL<UpdateModel> updateAllColumns(Permission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(permId).equalTo(record::getPermId)
                .set(permName).equalTo(record::getPermName)
                .set(permDesc).equalTo(record::getPermDesc)
                .set(permUrl).equalTo(record::getPermUrl)
                .set(permCreTime).equalTo(record::getPermCreTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.028+08:00", comments="Source Table: permission")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Permission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(permId).equalToWhenPresent(record::getPermId)
                .set(permName).equalToWhenPresent(record::getPermName)
                .set(permDesc).equalToWhenPresent(record::getPermDesc)
                .set(permUrl).equalToWhenPresent(record::getPermUrl)
                .set(permCreTime).equalToWhenPresent(record::getPermCreTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.029+08:00", comments="Source Table: permission")
    default int updateByPrimaryKey(Permission record) {
        return update(c ->
            c.set(permName).equalTo(record::getPermName)
            .set(permDesc).equalTo(record::getPermDesc)
            .set(permUrl).equalTo(record::getPermUrl)
            .set(permCreTime).equalTo(record::getPermCreTime)
            .where(permId, isEqualTo(record::getPermId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.029+08:00", comments="Source Table: permission")
    default int updateByPrimaryKeySelective(Permission record) {
        return update(c ->
            c.set(permName).equalToWhenPresent(record::getPermName)
            .set(permDesc).equalToWhenPresent(record::getPermDesc)
            .set(permUrl).equalToWhenPresent(record::getPermUrl)
            .set(permCreTime).equalToWhenPresent(record::getPermCreTime)
            .where(permId, isEqualTo(record::getPermId))
        );
    }
}