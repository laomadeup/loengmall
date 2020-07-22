package com.loengmall.goods.service;
import com.loengmall.goods.pojo.Template;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:mapengliang
 * @Description:Template业务层接口
 * @Date 2020/07/21 22:24
 *****/
public interface TemplateService {

    /**
     * <p>根据分类Id获取模版</p>
     *
     * * @param categoryId
     *
     * @return java.util.List<com.loengmall.goods.pojo.Template>
     *
     * @author mapengliang
     * @createTime 2020/7/22 9:26
     */
    List<Template> findByCategory(Integer categoryId);
    
    /***
     * Template多条件分页查询
     * @param template
     * @param page
     * @param size
     * @return
     */
    PageInfo<Template> findPage(Template template, int page, int size);

    /***
     * Template分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Template> findPage(int page, int size);

    /***
     * Template多条件搜索方法
     * @param template
     * @return
     */
    List<Template> findList(Template template);

    /***
     * 删除Template
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Template数据
     * @param template
     */
    void update(Template template);

    /***
     * 新增Template
     * @param template
     */
    void add(Template template);

    /**
     * 根据ID查询Template
     * @param id
     * @return
     */
     Template findById(Integer id);

    /***
     * 查询所有Template
     * @return
     */
    List<Template> findAll();
}
