package com.huston.microblog.verification.mapper;

import static com.huston.microblog.verification.mapper.VerificationPictureDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.verification.model.domain.VerificationPicture;
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
public interface VerificationPictureMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    BasicColumn[] selectList = BasicColumn.columnList(verPicId, verId, resId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.verPicId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<VerificationPicture> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("VerificationPictureResult")
    Optional<VerificationPicture> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="VerificationPictureResult", value = {
        @Result(column="ver_pic_id", property="verPicId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ver_id", property="verId", jdbcType=JdbcType.BIGINT),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.BIGINT)
    })
    List<VerificationPicture> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, verificationPicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, verificationPicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int deleteByPrimaryKey(Long verPicId_) {
        return delete(c -> 
            c.where(verPicId, isEqualTo(verPicId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int insert(VerificationPicture record) {
        return MyBatis3Utils.insert(this::insert, record, verificationPicture, c ->
            c.map(verId).toProperty("verId")
            .map(resId).toProperty("resId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int insertSelective(VerificationPicture record) {
        return MyBatis3Utils.insert(this::insert, record, verificationPicture, c ->
            c.map(verId).toPropertyWhenPresent("verId", record::getVerId)
            .map(resId).toPropertyWhenPresent("resId", record::getResId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default Optional<VerificationPicture> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, verificationPicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default List<VerificationPicture> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, verificationPicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default List<VerificationPicture> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, verificationPicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default Optional<VerificationPicture> selectByPrimaryKey(Long verPicId_) {
        return selectOne(c ->
            c.where(verPicId, isEqualTo(verPicId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, verificationPicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    static UpdateDSL<UpdateModel> updateAllColumns(VerificationPicture record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(verId).equalTo(record::getVerId)
                .set(resId).equalTo(record::getResId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(VerificationPicture record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(verId).equalToWhenPresent(record::getVerId)
                .set(resId).equalToWhenPresent(record::getResId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int updateByPrimaryKey(VerificationPicture record) {
        return update(c ->
            c.set(verId).equalTo(record::getVerId)
            .set(resId).equalTo(record::getResId)
            .where(verPicId, isEqualTo(record::getVerPicId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-14T16:51:46.985+08:00", comments="Source Table: verification_picture")
    default int updateByPrimaryKeySelective(VerificationPicture record) {
        return update(c ->
            c.set(verId).equalToWhenPresent(record::getVerId)
            .set(resId).equalToWhenPresent(record::getResId)
            .where(verPicId, isEqualTo(record::getVerPicId))
        );
    }

    default List<VerificationPicture> selectByVerId(Long verId_){
        return select(c->
                c.where(verId, isEqualTo(verId_)));
    }
}