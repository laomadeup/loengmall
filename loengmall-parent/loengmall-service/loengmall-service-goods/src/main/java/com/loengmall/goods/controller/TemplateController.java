package com.loengmall.goods.controller;

import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.goods.pojo.Template;
import com.loengmall.goods.service.TemplateService;
import com.github.pagehelper.PageInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:mapengliang
 * @Description:
 * @Date 2020/07/21 22:24
 *****/

@RestController
@RequestMapping("/template")
@CrossOrigin
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /**
     * <p>根据分类ID查询模版成功</p>
     * <p>
     * * @param categoryId
     *
     * @return com.loeng.entity.Result<java.util.List < com.loengmall.goods.pojo.Template>>
     * @author mapengliang
     * @createTime 2020/7/22 9:25
     */
    @GetMapping(value = "/category/{id}")
    public Result<List<Template>> findByCategoryId(@PathVariable(value = "id") Integer categoryId) {
        List<Template> templates = templateService.findByCategory(categoryId);
        return new Result<>(true, StatusCode.OK, "根据分类ID查询模版成功!", templates);
    }

    /***
     * Template分页条件搜索实现
     * @param template
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Template template, @PathVariable int page, @PathVariable int size) {
        //调用TemplateService实现分页条件查询Template
        PageInfo<Template> pageInfo = templateService.findPage(template, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * Template分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用TemplateService实现分页查询Template
        PageInfo<Template> pageInfo = templateService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param template
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Template>> findList(@RequestBody(required = false) Template template) {
        //调用TemplateService实现条件查询Template
        List<Template> list = templateService.findList(template);
        return new Result<List<Template>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        //调用TemplateService实现根据主键删除
        templateService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改Template数据
     * @param template
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Template template, @PathVariable Integer id) {
        //设置主键值
        template.setId(id);
        //调用TemplateService实现修改Template
        templateService.update(template);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增Template数据
     * @param template
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Template template) {
        //调用TemplateService实现添加Template
        templateService.add(template);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 根据ID查询Template数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Template> findById(@PathVariable Integer id) {
        //调用TemplateService实现根据主键查询Template
        Template template = templateService.findById(id);
        return new Result<Template>(true, StatusCode.OK, "查询成功", template);
    }

    /***
     * 查询Template全部数据
     * @return
     */
    @GetMapping
    public Result<List<Template>> findAll() {
        //调用TemplateService实现查询所有Template
        List<Template> list = templateService.findAll();
        return new Result<List<Template>>(true, StatusCode.OK, "查询成功", list);
    }
}
