package com.loengmall.content.feign;

import com.github.pagehelper.PageInfo;
import com.loeng.entity.Result;
import com.loengmall.content.pojo.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:mapengliang
 * @Description:
 * @Date 2020/07/21 22:24
 *****/
@FeignClient(name="content")
@RequestMapping("/content")
public interface ContentFeign {

    /***
     * Content分页条件搜索实现
     * @param content
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Content content, @PathVariable int page, @PathVariable  int size);

    /***
     * Content分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param content
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Content>> findList(@RequestBody(required = false) Content content);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改Content数据
     * @param content
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Content content,@PathVariable Long id);

    /***
     * 新增Content数据
     * @param content
     * @return
     */
    @PostMapping
    Result add(@RequestBody Content content);

    /***
     * 根据ID查询Content数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Content> findById(@PathVariable Long id);

    /***
     * 查询Content全部数据
     * @return
     */
    @GetMapping
    Result<List<Content>> findAll();


    /**
     * <p>根据分类ID查询广告</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.content.pojo.Content>>
     *
     * @author mapengliang
     * @createTime 2020/8/13 9:16
     */
    @GetMapping(value = "/list/category/{id}")
    Result<List<Content>> findByCategory(@PathVariable Long id);
}