package com.huston.microblog.auth.mapper;

import static com.huston.microblog.auth.mapper.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.huston.microblog.auth.model.domain.User;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
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
public interface UserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.003+08:00", comments="Source Table: user")
    BasicColumn[] selectList = BasicColumn.columnList(userId, userName, userNameSetTime, userNameUpdateTimes, userEmail, userPhone, userPassword, userSex, userBirthday, userIntro, resId, userCreTime, userAvailTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.985+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.987+08:00", comments="Source Table: user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.988+08:00", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.userId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.993+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.994+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name_set_time", property="userNameSetTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_name_update_times", property="userNameUpdateTimes", jdbcType=JdbcType.TINYINT),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.TINYINT),
        @Result(column="user_birthday", property="userBirthday", jdbcType=JdbcType.DATE),
        @Result(column="user_intro", property="userIntro", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_cre_time", property="userCreTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_avail_time", property="userAvailTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.996+08:00", comments="Source Table: user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.996+08:00", comments="Source Table: user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.997+08:00", comments="Source Table: user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.998+08:00", comments="Source Table: user")
    default int deleteByPrimaryKey(Long userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:32.998+08:00", comments="Source Table: user")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userName).toProperty("userName")
            .map(userNameSetTime).toProperty("userNameSetTime")
            .map(userNameUpdateTimes).toProperty("userNameUpdateTimes")
            .map(userEmail).toProperty("userEmail")
            .map(userPhone).toProperty("userPhone")
            .map(userPassword).toProperty("userPassword")
            .map(userSex).toProperty("userSex")
            .map(userBirthday).toProperty("userBirthday")
            .map(userIntro).toProperty("userIntro")
            .map(resId).toProperty("resId")
            .map(userCreTime).toProperty("userCreTime")
            .map(userAvailTime).toProperty("userAvailTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.001+08:00", comments="Source Table: user")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(userNameSetTime).toPropertyWhenPresent("userNameSetTime", record::getUserNameSetTime)
            .map(userNameUpdateTimes).toPropertyWhenPresent("userNameUpdateTimes", record::getUserNameUpdateTimes)
            .map(userEmail).toPropertyWhenPresent("userEmail", record::getUserEmail)
            .map(userPhone).toPropertyWhenPresent("userPhone", record::getUserPhone)
            .map(userPassword).toPropertyWhenPresent("userPassword", record::getUserPassword)
            .map(userSex).toPropertyWhenPresent("userSex", record::getUserSex)
            .map(userBirthday).toPropertyWhenPresent("userBirthday", record::getUserBirthday)
            .map(userIntro).toPropertyWhenPresent("userIntro", record::getUserIntro)
            .map(resId).toPropertyWhenPresent("resId", record::getResId)
            .map(userCreTime).toPropertyWhenPresent("userCreTime", record::getUserCreTime)
            .map(userAvailTime).toPropertyWhenPresent("userAvailTime", record::getUserAvailTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.005+08:00", comments="Source Table: user")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.006+08:00", comments="Source Table: user")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.007+08:00", comments="Source Table: user")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.008+08:00", comments="Source Table: user")
    default Optional<User> selectByPrimaryKey(Long userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.009+08:00", comments="Source Table: user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.009+08:00", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userName).equalTo(record::getUserName)
                .set(userNameSetTime).equalTo(record::getUserNameSetTime)
                .set(userNameUpdateTimes).equalTo(record::getUserNameUpdateTimes)
                .set(userEmail).equalTo(record::getUserEmail)
                .set(userPhone).equalTo(record::getUserPhone)
                .set(userPassword).equalTo(record::getUserPassword)
                .set(userSex).equalTo(record::getUserSex)
                .set(userBirthday).equalTo(record::getUserBirthday)
                .set(userIntro).equalTo(record::getUserIntro)
                .set(resId).equalTo(record::getResId)
                .set(userCreTime).equalTo(record::getUserCreTime)
                .set(userAvailTime).equalTo(record::getUserAvailTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.01+08:00", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userName).equalToWhenPresent(record::getUserName)
                .set(userNameSetTime).equalToWhenPresent(record::getUserNameSetTime)
                .set(userNameUpdateTimes).equalToWhenPresent(record::getUserNameUpdateTimes)
                .set(userEmail).equalToWhenPresent(record::getUserEmail)
                .set(userPhone).equalToWhenPresent(record::getUserPhone)
                .set(userPassword).equalToWhenPresent(record::getUserPassword)
                .set(userSex).equalToWhenPresent(record::getUserSex)
                .set(userBirthday).equalToWhenPresent(record::getUserBirthday)
                .set(userIntro).equalToWhenPresent(record::getUserIntro)
                .set(resId).equalToWhenPresent(record::getResId)
                .set(userCreTime).equalToWhenPresent(record::getUserCreTime)
                .set(userAvailTime).equalToWhenPresent(record::getUserAvailTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.011+08:00", comments="Source Table: user")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(userNameSetTime).equalTo(record::getUserNameSetTime)
            .set(userNameUpdateTimes).equalTo(record::getUserNameUpdateTimes)
            .set(userEmail).equalTo(record::getUserEmail)
            .set(userPhone).equalTo(record::getUserPhone)
            .set(userPassword).equalTo(record::getUserPassword)
            .set(userSex).equalTo(record::getUserSex)
            .set(userBirthday).equalTo(record::getUserBirthday)
            .set(userIntro).equalTo(record::getUserIntro)
            .set(resId).equalTo(record::getResId)
            .set(userCreTime).equalTo(record::getUserCreTime)
            .set(userAvailTime).equalTo(record::getUserAvailTime)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-12-20T16:41:33.012+08:00", comments="Source Table: user")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(userNameSetTime).equalToWhenPresent(record::getUserNameSetTime)
            .set(userNameUpdateTimes).equalToWhenPresent(record::getUserNameUpdateTimes)
            .set(userEmail).equalToWhenPresent(record::getUserEmail)
            .set(userPhone).equalToWhenPresent(record::getUserPhone)
            .set(userPassword).equalToWhenPresent(record::getUserPassword)
            .set(userSex).equalToWhenPresent(record::getUserSex)
            .set(userBirthday).equalToWhenPresent(record::getUserBirthday)
            .set(userIntro).equalToWhenPresent(record::getUserIntro)
            .set(resId).equalToWhenPresent(record::getResId)
            .set(userCreTime).equalToWhenPresent(record::getUserCreTime)
            .set(userAvailTime).equalToWhenPresent(record::getUserAvailTime)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    default List<User> selectByUserPhone(String userPhone_) {
        return select(c ->
                c.where(userPhone, isEqualTo(userPhone_)));
    }

    default List<User> selectByUserEmail(String userEmail_) {
        return select(c ->
                c.where(userEmail, isEqualTo(userEmail_)));
    }

    default Optional<User> selectUserPhoneByUserId(Long userId_){
        BasicColumn[] selectingColumns = BasicColumn.columnList(userPhone);
        return MyBatis3Utils.selectOne(this::selectOne, selectingColumns, user, c ->
                c.where(userId, isEqualTo(userId_)));
    }

    default Optional<User> selectUserEmailByUserId(Long userId_){
        BasicColumn[] selectingColumns = BasicColumn.columnList(userEmail);
        return MyBatis3Utils.selectOne(this::selectOne, selectingColumns, user, c ->
                c.where(userId, isEqualTo(userId_)));
    }

    default Optional<User> selectUserPasswordByUserId(Long userId_){
        BasicColumn[] selectingColumns = BasicColumn.columnList(userPassword);
        return MyBatis3Utils.selectOne(this::selectOne, selectingColumns, user, c ->
                c.where(userId, isEqualTo(userId_)));
    }

    default int updateUserPasswordByUserEmail(String userEmail_, String userPassword_){
        return update(c->
                c.set(userPassword).equalTo(userPassword_)
                .where(userEmail, isEqualTo(userEmail_)));
    }
    default int updateUserPasswordByUserPhone(String userPhone_, String userPassword_){
        return update(c->
                c.set(userPassword).equalTo(userPassword_)
                        .where(userPhone, isEqualTo(userPhone_)));
    }
}