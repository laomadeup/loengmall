package com.loengmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Spec;
import com.loengmall.service.SpecService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 11:24
 * @desc
 */
@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private Mapper specMapper;

    /**
     * <p>分页条件查询</p>
     *
     * * @param spec
 * @param page
 * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Spec>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:37
     */
    @Override
    public PageInfo<Spec> findPage(Spec spec, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(spec);
        List list = specMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    /**
     * <p>findPage</p>
     *
     * * @param page
     * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Spec>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:36
     */
    @Override
    public PageInfo<Spec> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(specMapper.selectAll());
    }

    /**
     * <p>findList</p>
     *
     * * @param spec
     *
     * @return java.util.List<com.loengmall.goods.pojo.Spec>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:30
     */
    @Override
    public List<Spec> findList(Spec spec) {
        Example example = createExample(spec);
        return specMapper.selectByExample(example);
    }

    public Example createExample(Spec spec){

        Example example = new Example(Spec.class);
        Example.Criteria criteria = example.createCriteria();
        if(spec != null){

            // ID
            if(spec.getId() != null){
                criteria.andEqualTo("id",spec.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(spec.getName())){
                criteria.andLike("name","%"+spec.getName()+"%");
            }
            // 规格选项
            if(!StringUtils.isEmpty(spec.getOptions())){
                criteria.andEqualTo("options",spec.getOptions());
            }
            // 排序
            if(spec.getSeq() != null){
                criteria.andEqualTo("seq",spec.getSeq());
            }
            // 模板ID
            if(spec.getTemplateId() != null){
                criteria.andEqualTo("templateId",spec.getTemplateId());
            }

        }
        return example;
    }

    /**
     * <p>delete</p>
     *
     * * @param id
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:27
     */
    @Override
    public void delete(Integer id) {
        specMapper.deleteByPrimaryKey(id);
    }

    /**
     * <p>update</p>
     *
     * * @param spec
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:26
     */
    @Override
    public void update(Spec spec) {
        specMapper.updateByPrimaryKeySelective(spec);
    }

    /**
     * <p>add</p>
     *
     * * @param spec
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:26
     */
    @Override
    public void add(Spec spec) {
        specMapper.insertSelective(spec);
    }

    /**
     * <p>findById</p>
     *
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Spec
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:26
     */
    @Override
    public Spec findById(Integer id) {
        return (Spec) specMapper.selectByPrimaryKey(id);
    }

    /**
     * <p>findAll</p>
     *
     * * @param 
     *
     * @return java.util.List<com.loengmall.goods.pojo.Spec>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:25
     */
    @Override
    public List<Spec> findAll() {
        return specMapper.selectAll();
    }
}
