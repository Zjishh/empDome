package com.zjh.emp.controller;

import com.zjh.emp.pojo.Emp;
import com.zjh.emp.pojo.PageBean;
import com.zjh.emp.pojo.Result;
import com.zjh.emp.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
                      String name, Short gender,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {  //参数和前端完全一致即可自动传递过来
        log.info("根据分页数和页进行查询name={}，gender={}，begin={}，end={}", name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("根据ID批量删除");
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result list(@PathVariable Integer id){
        log.info("查询byID"); //使用Slf4j
        log.info(id.toString());
        Emp emp= empService.getbyid(id);
        return Result.success(emp);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新建保存员工");
        empService.save(emp);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("g更新");
        empService.update(emp);
        return Result.success();
    }


}
