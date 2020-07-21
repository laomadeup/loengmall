package com.itheima.code.build;

import freemarker.template.Template;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/****
 * @Author:mapengliang
 * @Description:Pojo构建
 * @Date 2020/07/21 22:24
 *****/
public class PojoBuilder {


    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        //生成Pojo层文件
        BuilderFactory.builder(dataModel,
                "/template/pojo",
                "Pojo.java",
                TemplateBuilder.PACKAGE_POJO,
                ".java");
    }

}
