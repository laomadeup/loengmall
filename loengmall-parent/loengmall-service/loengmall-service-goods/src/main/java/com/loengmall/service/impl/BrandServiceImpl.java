package com.loengmall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loengmall.dao.BrandMapper;
import com.loengmall.goods.pojo.Brand;
import com.loengmall.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    /**
     * <p>分页条件查询</p>
     * <p>
     * * @param brand
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/17 21:51
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {

        PageHelper.startPage(page, size);
        Example example = createExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);

        return new PageInfo<>(brands);
    }

    /**
     * <p>分页查询</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/17 17:29
     */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();

        return new PageInfo<>(brands);
    }

    /**
     * <p>多条件查询</p>
     * <p>
     * * @param brand
     *
     * @return java.util.List<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/17 10:06
     */
    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /**
     * <p>条件构建</p>
     * <p>
     * * @param brand
     *
     * @return tk.mybatis.mapper.entity.Example
     * @author mapengliang
     * @createTime 2020/7/17 10:27
     */
    public Example createExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {

            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }

            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }


    /**
     * <p>delete</p>
     * <p>
     * * @param id
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/17 9:46
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * <p>修改品牌</p>
     * <p>
     * * @param brand
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/17 9:39
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void add(Brand brand) {
        //通用Mapper方法中有selective的都会忽略空值
        brandMapper.insertSelective(brand);
    }

    /**
     * <p>根据Id获取brand</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Brand
     * @author mapengliang
     * @createTime 2020/7/17 8:40
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * <p>查询所有</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Brand>
     * @author mapengliang
     * @createTime 2020/7/16 22:25
     */
    @Override
    public List<Brand> findAll() {
//        查询所有->通用Mapper.selectAll()
        return brandMapper.selectAll();
    }
}
