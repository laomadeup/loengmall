package com.loengmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Template;
import com.loengmall.service.TemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 10:26
 * @desc
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private Mapper templateMapper;

    /**
     * <p>findPage</p>
     * <p>
     * * @param template
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 10:42
     */
    @Override
    public PageInfo<Template> findPage(Template template, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Example example = createExample(template);
        List list = templateMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    /**
     * <p>findPage</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 10:40
     */
    @Override
    public PageInfo<Template> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List list = templateMapper.selectAll();
        return new PageInfo<>(list);
    }

    /**
     * <p>findList</p>
     * <p>
     * * @param template
     *
     * @return java.util.List<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 10:37
     */
    @Override
    public List<Template> findList(Template template) {
        Example example = createExample(template);
        return templateMapper.selectByExample(example);
    }

    /**
     * <p>createExample</p>
     * <p>
     * * @param template
     *
     * @return tk.mybatis.mapper.entity.Example
     * @author mapengliang
     * @createTime 2020/7/21 10:36
     */
    public Example createExample(Template template) {
        Example example = new Example(Template.class);
        Example.Criteria criteria = example.createCriteria();
        if (template != null) {
            // ID
            if (template.getId() != null) {
                criteria.andEqualTo("id", template.getId());
            }
            // 模板名称
            if (!StringUtils.isEmpty(template.getName())) {
                criteria.andLike("name", "%" + template.getName() + "%");
            }
            // 规格数量
            if (template.getSpecNum() != null) {
                criteria.andEqualTo("specNum", template.getSpecNum());
            }
            // 参数数量
            if (template.getParaNum() != null) {
                criteria.andEqualTo("paraNum", template.getParaNum());
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
     * @createTime 2020/7/21 10:29
     */
    @Override
    public void delete(Integer id) {
        templateMapper.deleteByPrimaryKey(id);
    }

    /**
     * <p>update</p>
     * <p>
     * * @param template
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 10:29
     */
    @Override
    public void update(Template template) {
        templateMapper.updateByPrimaryKeySelective(template);
    }

    /**
     * <p>add</p>
     * <p>
     * * @param template
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 10:29
     */
    @Override
    public void add(Template template) {
        templateMapper.insertSelective(template);
    }

    /**
     * <p>findById</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Template
     * @author mapengliang
     * @createTime 2020/7/21 10:28
     */
    @Override
    public Template findById(Integer id) {
        return (Template) templateMapper.selectByPrimaryKey(id);
    }

    /**
     * <p>findAll</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 10:28
     */
    @Override
    public List<Template> findAll() {
        return templateMapper.selectAll();
    }
}
