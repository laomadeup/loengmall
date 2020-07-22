package com.loengmall.goods.service;
import com.loengmall.goods.pojo.Category;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:mapengliang
 * @Description:Category业务层接口
 * @Date 2020/07/21 22:24
 *****/
public interface CategoryService {
    
    /**
     * <p>根据父ID查询分类</p>
     *
     * * @param 
     *
     * @return java.util.List<com.loengmall.goods.pojo.Category>
     *
     * @author mapengliang
     * @createTime 2020/7/22 8:29
     */
    List<Category> findByParentId(Integer pid);
    
    

    /***
     * Category多条件分页查询
     * @param category
     * @param page
     * @param size
     * @return
     */
    PageInfo<Category> findPage(Category category, int page, int size);

    /***
     * Category分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Category> findPage(int page, int size);

    /***
     * Category多条件搜索方法
     * @param category
     * @return
     */
    List<Category> findList(Category category);

    /***
     * 删除Category
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Category数据
     * @param category
     */
    void update(Category category);

    /***
     * 新增Category
     * @param category
     */
    void add(Category category);

    /**
     * 根据ID查询Category
     * @param id
     * @return
     */
     Category findById(Integer id);

    /***
     * 查询所有Category
     * @return
     */
    List<Category> findAll();
}
