package com.loengmall.goods.service;
import com.loengmall.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:mapengliang
 * @Description:Brand业务层接口
 * @Date 2020/07/21 22:24
 *****/
public interface BrandService {


    /**
     * <p>根据分类Id查询品牌</p>
     *
     * * @param categoryid
     *
     * @return java.util.List<com.loengmall.goods.pojo.Brand>
     *
     * @author mapengliang
     * @createTime 2020/7/22 8:41
     */
    List<Brand> findByCategory(Integer categoryid);

    /***
     * Brand多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    /***
     * Brand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(int page, int size);

    /***
     * Brand多条件搜索方法
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /***
     * 删除Brand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Brand数据
     * @param brand
     */
    void update(Brand brand);

    /***
     * 新增Brand
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据ID查询Brand
     * @param id
     * @return
     */
     Brand findById(Integer id);

    /***
     * 查询所有Brand
     * @return
     */
    List<Brand> findAll();
}
