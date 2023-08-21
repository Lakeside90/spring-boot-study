package com.demozi.spring.boot.data.mysql.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

/**
 * TODO
 *
 * @author wujian  2023/8/21 16:10
 */
public class TestGenCode {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://172.31.97.139:3306/test_db?useSSL=false&autoReconnect=true&characterEncoding=utf8", "root", "root")
                .globalConfig(builder ->
                        builder.author("lakeside") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                )
                .packageConfig(builder ->
                        builder.parent("com.demozi.spring.boot.data.mysql.mybatisplus") // 设置父包名
                                .moduleName("gencode") // 设置父包模块名
                )
                .strategyConfig(builder ->
                        builder.addInclude("tb_user")
                )
                .execute();
    }
}
