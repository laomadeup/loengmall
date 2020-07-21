package com.loengmall.service;

import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Spec;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 11:23
 * @desc
 */
public interface SpecService {

    /**
     * <p>findPage</p>
     * <p>
     * * @param Spec
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Spec>
     * @author mapengliang
     * @createTime 2020/7/21 8:58
     */
    PageInfo<Spec> findPage(Spec spec, Integer page, Integer size);

    /**
     * <p>findPage</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Spec>
     * @author mapengliang
     * @createTime 2020/7/21 8:51
     */
    PageInfo<Spec> findPage(Integer page, Integer size);

    /**
     * <p>findList</p>
     * <p>
     * * @param Spec
     *
     * @return java.util.List<com.loengmall.goods.pojo.Spec>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    List<Spec> findList(Spec spec);


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
     * * @param Spec
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void update(Spec spec);

    /**
     * <p>add</p>
     * <p>
     * * @param Spec
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void add(Spec spec);


    /**
     * <p>findById</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Spec
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    Spec findById(Integer id);


    /**
     * <p>findAll</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Spec>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    public List<Spec> findAll();

}
