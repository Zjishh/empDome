package com.zjh.emp.service;

import com.zjh.emp.pojo.Dept;
import com.zjh.emp.pojo.Emp;
import com.zjh.emp.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender,
                  LocalDate begin,
                  LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getbyid(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
