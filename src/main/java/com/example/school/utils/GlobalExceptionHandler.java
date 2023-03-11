package com.example.school.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/8 18:09
 */
@Controller
@Slf4j
public class GlobalExceptionHandler {

    //全局异常处理
    //指定出现什么异常执行此方法
    @ExceptionHandler(Exception.class)
    @ResponseBody//为了返回数据
    public Result error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().message("执行了全局异常");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//为了返回数据
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error().message("执行了ArithmeticException异常");
    }

    //自定义异常
    @ExceptionHandler(SchoolException.class)
    @ResponseBody
    public Result error(SchoolException e){
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMsg());
    }
}
