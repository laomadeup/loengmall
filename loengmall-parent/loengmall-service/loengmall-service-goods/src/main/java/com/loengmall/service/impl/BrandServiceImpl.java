package com.loengmall.service.impl;

import com.loengmall.dao.BrandMapper;
import com.loengmall.goods.pojo.Brand;
import com.loengmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

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
    @Override
    public List<Brand> findAll() {
//        查询所有->通用Mapper.selectAll()
        return brandMapper.selectAll();
    }
}
