package com.loengmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loengmall.dao.ParaMapper;
import com.loengmall.goods.pojo.Para;
import com.loengmall.service.ParaService;
import io.swagger.annotations.ExampleProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 11:54
 * @desc
 */
@Service
public class ParaServiceImpl implements ParaService {

    @Autowired
    private Mapper paraMapper;

    /**
     * <p>findPage</p>
     *
     * * @param para
 * @param page
 * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Para>
     *
     * @author mapengliang
     * @createTime 2020/7/21 14:20
     */
    @Override
    public PageInfo<Para> findPage(Para para, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(para);
        List paraExamples = paraMapper.selectByExample(example);

        return new PageInfo<>(paraExamples);
    }

    /**
     * <p>findPage</p>
     *
     * * @param page
     * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Para>
     *
     * @author mapengliang
     * @createTime 2020/7/21 13:00
     */
    @Override
    public PageInfo<Para> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List list = paraMapper.selectAll();
        return new PageInfo<>(list);
    }

    /**
     * <p>findList</p>
     *
     * * @param para
     *
     * @return java.util.List<com.loengmall.goods.pojo.Para>
     *
     * @author mapengliang
     * @createTime 2020/7/21 12:57
     */
    @Override
    public List<Para> findList(Para para) {
        Example example = createExample(para);
        return paraMapper.selectByExample(example);
    }


    public Example createExample(Para para) {

        Example example = new Example(Para.class);
        Example.Criteria criteria = example.createCriteria();
        if (para != null) {
            // id
            if (para.getId() != null) {
                criteria.andEqualTo("id", para.getId());
            }
            // 名称
            if (!StringUtils.isEmpty(para.getName())) {
                criteria.andLike("name", "%" + para.getName() + "%");
            }
            // 选项
            if (!StringUtils.isEmpty(para.getOptions())) {
                criteria.andEqualTo("options", para.getOptions());
            }
            // 排序
            if (para.getSeq() != null) {
                criteria.andEqualTo("seq", para.getSeq());
            }
            // 模板ID
            if (para.getTemplateId() != null) {
                criteria.andEqualTo("templateId", para.getTemplateId());
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
     * @createTime 2020/7/21 12:50
     */
    @Override
    public void delete(Integer id) {

        paraMapper.deleteByPrimaryKey(id);
    }

    /**
     * <p>update</p>
     * <p>
     * * @param para
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 12:50
     */
    @Override
    public void update(Para para) {
        paraMapper.updateByPrimaryKeySelective(para);
    }

    /**
     * <p>add</p>
     * <p>
     * * @param para
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 12:49
     */
    @Override
    public void add(Para para) {
        paraMapper.insertSelective(para);
    }

    /**
     * <p>findById</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Para
     * @author mapengliang
     * @createTime 2020/7/21 12:48
     */
    @Override
    public Para findById(Integer id) {
        return (Para) paraMapper.selectByPrimaryKey(id);
    }

    /**
     * <p>findAll</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Para>
     * @author mapengliang
     * @createTime 2020/7/21 12:41
     */
    @Override
    public List<Para> findAll() {
        return paraMapper.selectAll();
    }
}
