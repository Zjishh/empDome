package com.zjh.emp.service;

import com.zjh.emp.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender,
                  LocalDate begin,
                  LocalDate end);
}
