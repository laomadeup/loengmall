package com.loengmall.goods.dao;

import com.loengmall.goods.pojo.Template;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:mapengliang
 * @Description:Template的Dao
 * @Date 2020/07/21 22:24
 *****/
public interface TemplateMapper extends Mapper<Template> {
    @Select("select * from tb_template tb,tb_category tc where tc.template_id = tb.id and tc.id=#{categoryId}")
    List<Template> findByCategory(Integer categoryId);
}
