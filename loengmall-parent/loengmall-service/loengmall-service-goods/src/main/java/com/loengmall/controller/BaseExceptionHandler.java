package com.loengmall.controller;

import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: loengmall
 * @description: 异常处理类
 * @author: mapengliang
 * @create: 2020-07-17 22:03
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * <p>异常处理</p>
     *
     * * @param e
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/17 22:05
     */
    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(true, StatusCode.ERROR,e.getMessage());
    }


}