package com.zsp.zspdongbaomallgenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;

public class DongbaoGenerator {
    public static void main(String[] args) {
        // 构建一个代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();

        String separator = File.separator;
        globalConfig.setOutputDir("D:\\myWorkSpace\\back_end\\java\\mashibing\\my-java-project\\zsp-dongbao-mall-parent\\zsp-dongbao-mall-service\\zsp-dongbao-ums-service\\src\\main\\java");
        globalConfig.setAuthor("张世平");
        globalConfig.setOpen(false);//打开目录
        globalConfig.setFileOverride(true);//是否覆盖
        globalConfig.setServiceName("%sService");//去Service的I前缀。
        globalConfig.setIdType(IdType.ID_WORKER);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(false);

        autoGenerator.setGlobalConfig(globalConfig);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/zsp_dongbao_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("mysql");
        dataSourceConfig.setDbType(DbType.MYSQL);

        autoGenerator.setDataSource(dataSourceConfig);

        // 包设置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.zsp.zspdongbaoums");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");

        autoGenerator.setPackageInfo(packageConfig);

        // 策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("ums_member");//表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 下划线转驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);// 列 下划线转驼峰
        strategyConfig.setEntityLombokModel(true);//lombok 开启
        strategyConfig.setLogicDeleteFieldName("deleted");

        // 自动填充
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModify = new TableFill("update_time",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModify);

        strategyConfig.setTableFillList(tableFills);

        //乐观锁
        strategyConfig.setVersionFieldName("version");

        // restcontroller
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);// localhost:xxx/hello_2

        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();


    }
}
