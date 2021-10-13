package com.yiwobao.springboot_12_plus_gen;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springboot12PlusGenApplicationTests {

    @Test
    public void generate() {

        // 创建代码生成器对象
        AutoGenerator generator = new AutoGenerator();

        // 指定模板引擎为FreeMarker，如果你使用默认的引擎velocity则无需此配置
        generator.setTemplateEngine(new FreemarkerTemplateEngine());




        // 创建全局配置对象
        GlobalConfig globalConfig = new GlobalConfig();
        // 指定生成文件的输出目录【默认 D 盘根目录】
        // System.getProperty("user.dir") 获取到的是当前项目的绝对路径
        // 输出目录示例：D:\IdeaProjects\mybatis-plus-demo\src\main\java
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        // 指定开发人员
        globalConfig.setAuthor("sanye");
        // 指定是否打开输出目录
        globalConfig.setOpen(false);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        // 指定全局配置
        generator.setGlobalConfig(globalConfig);

        // 创建包配置对象
        PackageConfig packageConfig = new PackageConfig();
        // 指定父包名
        packageConfig.setParent("com.yiwobao.springboot_12_plus_gen");
        // 指定包名配置
        generator.setPackageInfo(packageConfig);

        // 创建数据源配置对象
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 指定数据源信息
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("zhou");

        // 指定数据源配置
        generator.setDataSource(dataSourceConfig);


        // 创建策略配置对象
        StrategyConfig strategyConfig = new StrategyConfig();
        // 指定数据库表映射到实体的命名策略
        // 下划线转驼峰命名：underline_to_camel
        // 不做任何改变，原样输出：no_change
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 指定数据库表字段映射到实体的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 指定实体类是否采用 lombok 注解
        strategyConfig.setEntityLombokModel(true);
        // 指定生成的Controller类是否采用@RestController注解
        // 默认false：@Controller -> true：@RestController
        strategyConfig.setRestControllerStyle(true);

        // 指定策略配置
        generator.setStrategy(strategyConfig);


        // 执行生成
        generator.execute();


    }


}
