package com.zjh.emp.controller;

import com.zjh.emp.pojo.PageBean;
import com.zjh.emp.pojo.Result;
import com.zjh.emp.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 员工管理Controller
 */

@Slf4j //日志输出！！！！！
@RestController
//抽取路径
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result sel(@RequestParam(defaultValue = "1") Integer page,
                      @RequestParam(defaultValue = "10") Integer pageSize,
                      String name,Short gender,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {  //参数和前端完全一致即可自动传递过来
        log.info("根据分页数和页进行查询name={}，gender={}，begin={}，end={}",name,gender,begin,end);
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);

        return Result.success(pageBean);
    }



}
