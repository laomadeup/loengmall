package com.loengmall.goods.service;
import com.loengmall.goods.pojo.Goods;
import com.loengmall.goods.pojo.Spu;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:mapengliang
 * @Description:Spu业务层接口
 * @Date 2020/07/21 22:24
 *****/
public interface SpuService {

    /**
     * <p>批量上架</p>
     *
     * * @param ids
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/23 21:11
     */
    void putMany(Long[] ids);


    /**
     * <p>商品上架</p>
     *
     * * @param spuId
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/23 21:02
     */
    void put(Long spuId);


    /**
     * <p>商品下架</p>
     *
     * * @param spuId
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/23 21:02
     */
    void pull(Long spuId);


    /**
     * <p>审核商品</p>
     *
     * * @param spuId
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/23 20:55
     */
    void audit(Long spuId);


    /**
     * <p>根据商品Id查询商品信息</p>
     *
     * * @param id
     *
     * @return com.loengmall.goods.pojo.Goods
     *
     * @author mapengliang
     * @createTime 2020/7/22 21:57
     */
    Goods findGoodsById(Long id);


    /**
     * <p>添加商品信息</p>
     *
     * * @param goods
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/22 12:15
     */
     void saveGoods(Goods goods);


    /***
     * Spu多条件分页查询
     * @param spu
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    /***
     * Spu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(int page, int size);

    /***
     * Spu多条件搜索方法
     * @param spu
     * @return
     */
    List<Spu> findList(Spu spu);

    /***
     * 删除Spu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Spu数据
     * @param spu
     */
    void update(Spu spu);

    /***
     * 新增Spu
     * @param spu
     */
    void add(Spu spu);

    /**
     * 根据ID查询Spu
     * @param id
     * @return
     */
     Spu findById(Long id);

    /***
     * 查询所有Spu
     * @return
     */
    List<Spu> findAll();
}
