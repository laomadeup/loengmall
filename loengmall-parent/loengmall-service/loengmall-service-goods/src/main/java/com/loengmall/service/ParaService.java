package com.loengmall.service;

import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Para;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 11:53
 * @desc
 */
public interface ParaService {

    /**
     * <p>findPage</p>
     * <p>
     * * @param Para
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Para>
     * @author mapengliang
     * @createTime 2020/7/21 8:58
     */
    PageInfo<Para> findPage(Para para, Integer page, Integer size);

    /**
     * <p>findPage</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Para>
     * @author mapengliang
     * @createTime 2020/7/21 8:51
     */
    PageInfo<Para> findPage(Integer page, Integer size);

    /**
     * <p>findList</p>
     * <p>
     * * @param Para
     *
     * @return java.util.List<com.loengmall.goods.pojo.Para>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    List<Para> findList(Para para);


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
     * * @param Para
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void update(Para para);

    /**
     * <p>add</p>
     * <p>
     * * @param Para
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void add(Para para);


    /**
     * <p>findById</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Para
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    Para findById(Integer id);


    /**
     * <p>findAll</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Para>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    public List<Para> findAll();


}
