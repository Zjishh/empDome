package com.zjh.emp.exception;

import com.zjh.emp.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/****************************
 * @project empservice
 * @package com.zjh.emp.exception
 * @className GlobeExceptionHandler
 * @author Zjiah
 * @date 2023/10/13 17:10
 * @Description: 全局异常处理器*
 ****************************/


@RestControllerAdvice
public class GlobeExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e) {
        e.printStackTrace();
        return Result.error("操作失败，联系管理员");
    }
}
