package com.loengmall.service;

import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Album;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 8:47
 * @desc
 */
public interface AlbumService {

    /**
     * <p>findPage</p>
     * <p>
     * * @param album
     *
     * @param page
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Album>
     * @author mapengliang
     * @createTime 2020/7/21 8:58
     */
    PageInfo<Album> findPage(Album album, Integer page, Integer size);

    /**
     * <p>findPage</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Album>
     * @author mapengliang
     * @createTime 2020/7/21 8:51
     */
    PageInfo<Album> findPage(Integer page, Integer size);

    /**
     * <p>findList</p>
     * <p>
     * * @param album
     *
     * @return java.util.List<com.loengmall.goods.pojo.Album>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    List<Album> findList(Album album);


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
     * * @param album
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void update(Album album);

    /**
     * <p>add</p>
     * <p>
     * * @param album
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    void add(Album album);


    /**
     * <p>findById</p>
     * <p>
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Album
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    Album findById(Integer id);


    /**
     * <p>findAll</p>
     * <p>
     * * @param
     *
     * @return java.util.List<com.loengmall.goods.pojo.Album>
     * @author mapengliang
     * @createTime 2020/7/21 8:50
     */
    public List<Album> findAll();

}
