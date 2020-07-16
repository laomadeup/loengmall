package com.loengmall.controller;

import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.goods.pojo.Brand;
import com.loengmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
/*
* 跨域访问：A域名访问B域名的数据
* 域名或者请求端口或者协议不一致时候，就跨域了
* */
@CrossOrigin
public class BrandController {


    @Autowired
    private BrandService brandService;

    /**
     * <p>查询所有品牌</p>
     *
     * * @param
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/16 22:29
     */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        //相应结果封装
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌集合成功!",brands);
    }


}
