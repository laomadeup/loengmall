package com.loengmall.controller;

import com.github.pagehelper.PageInfo;
import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.goods.pojo.Para;
import com.loengmall.service.ParaService;
import com.loengmall.service.SpecService;
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
 * @createTime 2020/7/21 14:19
 * @desc
 */
@RestController
@RequestMapping(value = "/para")
@CrossOrigin
public class ParaController {

    @Autowired
    private ParaService paraServiceImpl;



    /**
     * <p>分页条件查询</p>
     *
     * * @param Para
     * @param page
     * @param size
     *
     * @return com.loeng.entity.Result<com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Para>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:46
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Para>> findPage(@RequestBody Para para,
                                           @PathVariable Integer page, @PathVariable Integer size){

        PageInfo<Para> paraPageInfo = paraServiceImpl.findPage(para, page, size);
        return new Result<PageInfo<Para>>(true, StatusCode.OK,"分页条件查询成功！",paraPageInfo);
    }


    /**
     * <p>findPage</p>
     *
     * * @param page
     * @param size
     *
     * @return com.loeng.entity.Result<com.github.pagehelper.PageInfo>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:49
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable Integer page,@PathVariable Integer size){

        PageInfo<Para> pageInfo = paraServiceImpl.findPage(page, size);
        return new Result<>(true,StatusCode.OK,"分页查询成功!",pageInfo);

    }


    /**
     * <p>不分页条件查询成功</p>
     *
     * * @param Para
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Para>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:52
     */
    @PostMapping(value = "/search")
    public Result<List<Para>> findList(@RequestBody Para para){
        List<Para> paras = paraServiceImpl.findList(para);
        return new Result<>(true,StatusCode.OK,"不分页条件查询成功!",paras);
    }

    /**
     * <p>delete</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:53
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){
        paraServiceImpl.delete(id);
        return new Result(true,StatusCode.OK,"删除参数模板成功");
    }


    /**
     * <p>update</p>
     *
     * * @param Para
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:55
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Para para){
        para.setId(id);
        paraServiceImpl.update(para);
        return new Result(true,StatusCode.OK,"修改参数模板成功!");
    }

    /**
     * <p>add</p>
     *
     * * @param Para
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:58
     */
    @PostMapping
    public Result add(@RequestBody Para para){
        paraServiceImpl.add(para);
        return new Result(true,StatusCode.OK,"新增参数模板成功!");
    }


    /**
     * <p>findById</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result<com.loengmall.goods.pojo.Para>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:05
     */
    @GetMapping(value = "/{id}")
    public Result<Para> findById(@PathVariable Integer id){
        Para para = paraServiceImpl.findById(id);
        return new Result<>(true, StatusCode.OK,"根据Id查询参数模板成功!",para);
    }

    /**
     * <p>findAll</p>
     *
     * * @param
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Para>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:10
     */
    @GetMapping
    public Result<List<Para>> findAll(){

        List<Para> paras = paraServiceImpl.findAll();
        return new Result<>(true,StatusCode.OK,"查询所有的参数模板",paras);
    }

}
