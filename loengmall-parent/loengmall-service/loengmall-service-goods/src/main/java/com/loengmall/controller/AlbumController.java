package com.loengmall.controller;

import com.github.pagehelper.PageInfo;
import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.goods.pojo.Album;
import com.loengmall.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/21 9:17
 * @desc
 */
@RestController
@RequestMapping(value = "/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    private AlbumService albumServiceImpl;

    /**
     * <p>分页条件查询</p>
     * <p>
     * * @param album
     *
     * @param page
     * @param size
     * @return com.loeng.entity.Result<com.github.pagehelper.PageInfo>
     * @author mapengliang
     * @createTime 2020/7/21 10:01
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody Album album,
                                     @PathVariable Integer page, @PathVariable Integer size) {

        PageInfo<Album> albumPageInfo = albumServiceImpl.findPage(album, page, size);
        return new Result<>(true, StatusCode.OK, "分页条件查询成功!", albumPageInfo);

    }

    /**
     * <p>分页查询</p>
     * <p>
     * * @param page
     *
     * @param size
     * @return com.loeng.entity.Result<com.github.pagehelper.PageInfo>
     * @author mapengliang
     * @createTime 2020/7/21 10:03
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable Integer page, @PathVariable Integer size) {

        PageInfo<Album> albumPageInfo = albumServiceImpl.findPage(page, size);
        return new Result<>(true, StatusCode.OK, "分页查询成功!", albumPageInfo);
    }

    /**
     * <p>不分页条件查询</p>
     *
     * * @param album
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Album>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:06
     */
    @PostMapping(value = "/search")
    public Result<List<Album>> findList(@RequestBody Album album){

        List<Album> list = albumServiceImpl.findList(album);
        return new Result<>(true,StatusCode.OK,"不分页条件查询成功",list);
    }

    /**
     * <p>delete</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:09
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){
        albumServiceImpl.delete(id);
        return new Result(true,StatusCode.OK,"删除成功!");
    }


    /**
     * <p>update</p>
     *
     * * @param id
     * @param album
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:11
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable Long id,@RequestBody Album album){
        album.setId(id);
        albumServiceImpl.update(album);
        return new Result(true,StatusCode.OK,"修改成功!");
    }


    /**
     * <p>add</p>
     *
     * * @param album
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:13
     */
    @PostMapping
    public Result add(@RequestBody Album album){
        albumServiceImpl.add(album);
        return new Result(true,StatusCode.OK,"新增相册成功!");
    }


    /**
     * <p>findById</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:15
     */
    @GetMapping(value = "/{id}")
    public Result<Album> findById(@PathVariable Integer id){
        Album album = albumServiceImpl.findById(id);
        return new Result(true,StatusCode.OK,"根据Id查询相册成功!",album);
    }

    /**
     * <p>findAll</p>
     *
     * * @param 
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Album>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:17
     */
    @GetMapping
    public Result<List<Album>> findAll(){
        List<Album> albums = albumServiceImpl.findAll();
        return new Result<>(true,StatusCode.OK,"查询所有相册成功！",albums);
    }

}
