package com.loengmall.dao;

import com.loengmall.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 *DAO 使用通用Mapper,DAO接口需要继承tk.mybatis.mapper.common.Mapper
 * 增加数据，调用Mapper.insert()
 * 增加数据，调用Mapper.insertSelective()
 *
 * 修改数据，调用Mapper.update(T)
 * 修改数据，调用Mapper.updateByPrimaryKey(T)
 *
 * 查询数据，根据Id查询Mapper.selectByPrimaryKey(ID)
 * 查询数据，条件查询Mapper.select(T)
 *
 * */
public interface BrandMapper extends Mapper<Brand> {




}
