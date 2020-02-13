package com.huston.microblog.mblog.util;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class MybatisGenerator {

    private void generate() throws InvalidConfigurationException, InterruptedException, SQLException, IOException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        Configuration config = new Configuration();

        //   ... 适当地填写配置对象 ...
        String contextId = "dsql";
        String targetRuntime="MyBatis3DynamicSql";
        String driverClass="com.mysql.cj.jdbc.Driver";
        String connectionURL="jdbc:mysql://localhost:3306/microblog_mblog";
        String userId="root";
        String password="root";
        String urlProperty="?nullCatalogMeansCurrent=true";
        String targetProject="D:\\编程\\程序设计训练\\大四上\\毕业设计：微服务架构的微博社交平台\\microblog\\microblog-mblog\\src\\main\\java";
        String modelPackage="com.huston.microblog.mblog.model.domain";
        String mapperPackage="com.huston.microblog.mblog.mapper";
        String[] tables={"microblog","agree_microblog","collect","microblog_resource"};
        String[] ids={"mblog_id","agree_id","collect_id","mblog_res_id"};

        Context context = new Context(ModelType.CONDITIONAL);
        context.setId(contextId);
        context.setTargetRuntime(targetRuntime);

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass(driverClass);
        jdbcConnectionConfiguration.setConnectionURL(connectionURL+urlProperty);
        jdbcConnectionConfiguration.setUserId(userId);
        jdbcConnectionConfiguration.setPassword(password);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration=new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(modelPackage);
        javaModelGeneratorConfiguration.setTargetProject(targetProject);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration=new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage(mapperPackage);
        javaClientGeneratorConfiguration.setTargetProject(targetProject);
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        for(int i=0;i<tables.length;i++){
            TableConfiguration tableConfiguration=new TableConfiguration(context);
            tableConfiguration.setTableName(tables[i]);
            tableConfiguration.setGeneratedKey(new GeneratedKey(ids[i],"mysql",true,"post"));
            context.addTableConfiguration(tableConfiguration);
        }

        config.addContext(context);
        //   ... 配置对象填写完毕 ...

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args){
        try{
            new MybatisGenerator().generate();
        }catch (IOException | SQLException | InterruptedException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
