package com.loengmall.controller;

import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.goods.pojo.Brand;
import com.loengmall.service.BrandService;
import io.swagger.models.auth.In;
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
     * <p>条件查询</p>
     *
     * * @param brand
     *
     * @return com.loeng.entity.Result<java.util.List<com.loengmall.goods.pojo.Brand>>
     *
     * @author mapengliang
     * @createTime 2020/7/17 10:21
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){

        List<Brand> brands = brandService.findList(brand);
        return new Result<>(true,StatusCode.OK,"条件查询成功",brands);
    }
    
    
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id")Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功!");
    }

    /**
     * <p>update</p>
     *
     * * @param id
     * @param brand
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/17 9:46
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改品牌成功!");
    }


    /**
     * <p>修改品牌</p>
     *
     * * @param brand
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/17 9:39
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result<Brand>(true, StatusCode.OK,"新增品牌成功!");
    }
    
    
    
    
    /**
     * <p>根据Id查询品牌</p>
     *
     * * @param id
     *
     * @return com.loeng.entity.Result<com.loengmall.goods.pojo.Brand>
     *
     * @author mapengliang
     * @createTime 2020/7/17 9:03
     */
    @RequestMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id") Integer id){

        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK,"根据Id查询品牌成功!",brand);
    }


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
