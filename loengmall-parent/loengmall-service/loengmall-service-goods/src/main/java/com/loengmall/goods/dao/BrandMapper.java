package com.loengmall.goods.dao;

import com.loengmall.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:mapengliang
 * @Description:Brand的Dao
 * @Date 2020/07/21 22:24
 *****/
public interface BrandMapper extends Mapper<Brand> {
    @Select("select * from tb_brand tb,tb_category_brand tcb where tb.id = tcb.brand_id and tcb.category_id=#{categoryid}")
    List<Brand> findByCategory(Integer categoryid);
}
