package com.loengmall.goods.service;
import com.loengmall.goods.pojo.Para;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:mapengliang
 * @Description:Para业务层接口
 * @Date 2020/07/21 22:24
 *****/
public interface ParaService {

    /**
     * <p>根据分类ID查询参数</p>
     *
     * * @param categoryId
     *
     * @return java.util.List<com.loengmall.goods.pojo.Para>
     *
     * @author mapengliang
     * @createTime 2020/7/22 9:26
     */
    List<Para> findByCategory(Integer categoryId);
    
    
    /***
     * Para多条件分页查询
     * @param para
     * @param page
     * @param size
     * @return
     */
    PageInfo<Para> findPage(Para para, int page, int size);

    /***
     * Para分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Para> findPage(int page, int size);

    /***
     * Para多条件搜索方法
     * @param para
     * @return
     */
    List<Para> findList(Para para);

    /***
     * 删除Para
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Para数据
     * @param para
     */
    void update(Para para);

    /***
     * 新增Para
     * @param para
     */
    void add(Para para);

    /**
     * 根据ID查询Para
     * @param id
     * @return
     */
     Para findById(Integer id);

    /***
     * 查询所有Para
     * @return
     */
    List<Para> findAll();
}
