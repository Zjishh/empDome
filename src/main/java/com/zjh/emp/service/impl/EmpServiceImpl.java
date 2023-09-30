package com.zjh.emp.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjh.emp.mapper.EmpMapper;
import com.zjh.emp.pojo.Emp;
import com.zjh.emp.pojo.PageBean;
import com.zjh.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empMapper.count();
//
//        //获取结果列表
//        Integer a =  (page-1)*pageSize;
//        List<Emp> pages = empMapper.page(a, pageSize);
//
//        //封装bean对象
//        PageBean pageBean = new PageBean(count,pages);
//点睡的_(:з」∠)_
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender,
                         LocalDate begin,
                         LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //查询
        List<Emp> emplist = empMapper.list(name,gender,begin,end);
        //强转封装
        Page<Emp> pages = (Page<Emp>) emplist;

        //封装bean对象
        PageBean pageBean = new PageBean(pages.getTotal(),pages.getResult());

        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
}
