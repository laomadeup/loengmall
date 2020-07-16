package com.loengmall.service;

import com.loengmall.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    
    /**
     * <p>查询所有</p>
     *
     * * @param 
     *
     * @return java.util.List<com.loengmall.goods.pojo.Brand>
     *
     * @author mapengliang
     * @createTime 2020/7/16 22:25
     */
    List<Brand> findAll();
}
