package com.loengmall.service;

import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Brand;
import io.swagger.models.auth.In;

import java.util.List;

public interface BrandService {


    /**
     * <p>分页条件查询</p>
     * <p>
     * * @param brand
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/17 21:50
     */
    PageInfo<Brand> findPage(Brand brand, Integer page, Integer size);

    /**
     * <p>分页查询</p>
     * <p>
     * * @param page
     * * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/17 12:46
     */
    PageInfo<Brand> findPage(Integer page, Integer size);


    /**
     * <p>多条件查询</p>
     * <p>
     * * @param brand
     *
     * @return java.util.List<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/17 10:07
     */
    List<Brand> findList(Brand brand);


    /**
     * <p>delete</p>
     * <p>
     * * @param id
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/17 9:46
     */
    void delete(Integer id);


    /**
     * <p>修改品牌</p>
     * <p>
     * * @param brand
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/17 9:38
     */
    void update(Brand brand);


    /**
     * <p>增加品牌</p>
     * <p>
     * * @param brand
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/17 9:02
     */
    void add(Brand brand);


    /**
     * <p>根据ID获取brand</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Brand
     * @author mapengliang
     * @createTime 2020/7/17 8:40
     */
    Brand findById(Integer id);


    /**
     * <p>查询所有</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/16 22:25
     */
    List<Brand> findAll();
}
