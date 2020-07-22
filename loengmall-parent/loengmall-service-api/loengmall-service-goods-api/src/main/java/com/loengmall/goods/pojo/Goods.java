package com.loengmall.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/7/22 11:21
 * @desc 商品 spu与List<sku>组合信息
 */
public class Goods implements Serializable {
    private Spu spu;
    private List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
