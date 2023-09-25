package com.zjh.emp.controller;

import com.zjh.emp.pojo.Dept;
import com.zjh.emp.pojo.Result;
import com.zjh.emp.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j //日志输出！！！！！
@RestController
//抽取路径
@RequestMapping("/depts")
public class DeptController {

    //注入service的接口
    @Autowired
    private DeptService deptService;

//所有
    @GetMapping
    public Result list(){
        log.info("查询全部~~~~"); //使用Slf4j
        List<Dept> list = deptService.list();
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result list(@PathVariable Integer id){
        log.info("查询byID"); //使用Slf4j
        log.info(id.toString());
        Dept dept = deptService.listbyid(id);
        return Result.success(dept);
    }

    /**
     * @return {@link Result}
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据ID删除");
        deptService.delete(id);

        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("增加方法");
        deptService.add(dept);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改");
        deptService.update(dept);
        return Result.success();
    }
}
