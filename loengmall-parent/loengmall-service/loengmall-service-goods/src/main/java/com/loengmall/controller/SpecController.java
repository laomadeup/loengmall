package com.loengmall.controller;

import com.github.pagehelper.PageInfo;
import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.goods.pojo.Spec;
import com.loengmall.service.SpecService;
import com.loengmall.service.TemplateService;
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
 * @createTime 2020/7/21 11:38
 * @desc
 */
@RestController
@RequestMapping(value = "/spec")
@CrossOrigin
public class SpecController {

    @Autowired
    private SpecService specServiceImpl;


    /**
     * <p>分页条件查询</p>
     *
     * * @param Spec
     * @param page
     * @param size
     *
     * @return com.loeng.entity.Result<com.github.pagehelper.PageInfo<com.loengmall.goods.pojo.Spec>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:46
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Spec>> findPage(@RequestBody Spec spec,
                                               @PathVariable Integer page, @PathVariable Integer size){

        PageInfo<Spec> specPageInfo = specServiceImpl.findPage(spec, page, size);
        return new Result<PageInfo<Spec>>(true, StatusCode.OK,"分页条件查询成功！",specPageInfo);
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

        PageInfo<Spec> pageInfo = specServiceImpl.findPage(page, size);
        return new Result<>(true,StatusCode.OK,"分页查询成功!",pageInfo);

    }


    /**
     * <p>不分页条件查询成功</p>
     *
     * * @param Spec
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Spec>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:52
     */
    @PostMapping(value = "/search")
    public Result<List<Spec>> findList(@RequestBody Spec spec){
        List<Spec> templates = specServiceImpl.findList(spec);
        return new Result<>(true,StatusCode.OK,"不分页条件查询成功!",templates);
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
        specServiceImpl.delete(id);
        return new Result(true,StatusCode.OK,"删除参数模板成功");
    }


    /**
     * <p>update</p>
     *
     * * @param Spec
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:55
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Spec spec){
        spec.setId(id);
        specServiceImpl.update(spec);
        return new Result(true,StatusCode.OK,"修改参数模板成功!");
    }

    /**
     * <p>add</p>
     *
     * * @param Spec
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/21 10:58
     */
    @PostMapping
    public Result add(@RequestBody Spec spec){
        specServiceImpl.add(spec);
        return new Result(true,StatusCode.OK,"新增参数模板成功!");
    }


    /**
     * <p>findById</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result<com.loengmall.goods.pojo.Spec>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:05
     */
    @GetMapping(value = "/{id}")
    public Result<Spec> findById(@PathVariable Integer id){
        Spec Spec = specServiceImpl.findById(id);
        return new Result<>(true, StatusCode.OK,"根据Id查询参数模板成功!",Spec);
    }

    /**
     * <p>findAll</p>
     *
     * * @param
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Spec>>
     *
     * @author mapengliang
     * @createTime 2020/7/21 11:10
     */
    @GetMapping
    public Result<List<Spec>> findAll(){

        List<Spec> specs = specServiceImpl.findAll();
        return new Result<>(true,StatusCode.OK,"查询所有的参数模板",specs);
    }
    

}
