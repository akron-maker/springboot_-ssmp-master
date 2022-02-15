package com.akron.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:Akron
 * @Date:created in 14:51 2022/1/24
 */
//异常处理器
@RestControllerAdvice
public class projectExceptionDeals {
    @ExceptionHandler
    public resultsChange doException(Exception e){
        e.printStackTrace();
        return new resultsChange("服务器故障，请稍后再试！");
    }
}
