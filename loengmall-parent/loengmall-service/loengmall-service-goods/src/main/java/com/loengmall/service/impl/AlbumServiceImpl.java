package com.loengmall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loengmall.goods.pojo.Album;
import com.loengmall.service.AlbumService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 8:58
 * @desc
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private Mapper albumMapper;

    /**
     * <p>分页条件查询</p>
     *
     * * @param album
 * @param page
 * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Album>
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:10
     */
    @Override
    public PageInfo<Album> findPage(Album album, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(album);
        List albums = albumMapper.selectByExample(example);
        return new PageInfo<>(albums);
    }

    /**
     * <p>分页查询</p>
     *
     * * @param page
 * @param size
     *
     * @return com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Album>
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:11
     */
    @Override
    public PageInfo<Album> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);

        return new PageInfo<>(albumMapper.selectAll());
    }

    /**
     * <p>不分页条件查询</p>
     *
     * * @param album
     *
     * @return java.util.List<com.loengmall.goods.pojo.Album>
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:11
     */
    @Override
    public List<Album> findList(Album album) {
        Example example = createExample(album);
        return albumMapper.selectByExample(example);
    }

    /**
     * <p>delete</p>
     *
     * * @param id
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:11
     */
    @Override
    public void delete(Integer id) {
        albumMapper.deleteByPrimaryKey(id);
    }

    /**
     * <p>update</p>
     *
     * * @param album
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:11
     */
    @Override
    public void update(Album album) {
        albumMapper.updateByPrimaryKeySelective(album);
    }

    /**
     * <p>add</p>
     *
     * * @param album
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:11
     */
    @Override
    public void add(Album album) {
        albumMapper.insertSelective(album);
    }

    /**
     * <p>findById</p>
     *
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Album
     *
     * @author mapengliang
     * @createTime 2020/7/21 9:11
     */
    @Override
    public Album findById(Integer id) {
        return (Album) albumMapper.selectByPrimaryKey(id);
    }

    /**
     * <p>findAll</p>
     *
     * * @param 
     *
     * @return java.util.List<com.loengmall.goods.pojo.Album>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:26
     */
    @Override
    public List<Album> findAll() {
        return albumMapper.selectAll();
    }

    /**
     * Album构建查询对象
     * @param album
     * @return
     */
    public Example createExample(Album album){
        Example example=new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if(album!=null){
            // 编号
            if(album.getId() != null){
                criteria.andEqualTo("id",album.getId());
            }
            // 相册名称
            if(!StringUtils.isEmpty(album.getTitle())){
                criteria.andLike("title","%"+album.getTitle()+"%");
            }
            // 相册封面
            if(!StringUtils.isEmpty(album.getImage())){
                criteria.andEqualTo("image",album.getImage());
            }
            // 图片列表
            if(!StringUtils.isEmpty(album.getImageItems())){
                criteria.andEqualTo("imageItems",album.getImageItems());
            }
        }
        return example;
    }


}
