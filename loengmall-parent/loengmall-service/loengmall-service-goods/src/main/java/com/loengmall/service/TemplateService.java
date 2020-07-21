package com.loengmall.service;

import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Template;
import com.loengmall.goods.pojo.Template;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 9:14
 * @desc
 */
public interface TemplateService {

    /**
     * <p>findPage</p>
     * <p>
     * * @param Template
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 8:58
     */
    PageInfo<Template> findPage(Template template, Integer page, Integer size);

    /**
     * <p>findPage</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 8:51
     */
    PageInfo<Template> findPage(Integer page, Integer size);

    /**
     * <p>findList</p>
     * <p>
     * * @param Template
     *
     * @return java.util.List<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    List<Template> findList(Template template);


    /**
     * <p>delete</p>
     * <p>
     * * @param id
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void delete(Integer id);


    /**
     * <p>update</p>
     * <p>
     * * @param Template
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void update(Template template);

    /**
     * <p>add</p>
     * <p>
     * * @param Template
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void add(Template template);


    /**
     * <p>findById</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Template
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    Template findById(Integer id);


    /**
     * <p>findAll</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Template>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    public List<Template> findAll();


}
