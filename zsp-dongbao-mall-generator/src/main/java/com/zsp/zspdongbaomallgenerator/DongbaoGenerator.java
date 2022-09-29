package com.zsp.zspdongbaomallgenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

import java.io.File;

public class DongbaoGenerator {
    public static void main(String[] args) {
        // 构建一个代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();

        String separator = File.separator;
        globalConfig.setOutputDir("D:\\myWorkSpace\\back_end\\java\\mashibing\\my-java-project\\zsp-dongbao-mall-parent\\");

    }
}
