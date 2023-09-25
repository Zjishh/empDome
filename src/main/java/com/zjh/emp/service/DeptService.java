package com.zjh.emp.service;

import com.zjh.emp.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    List<Dept> list();

    Dept listbyid(Integer id);

    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);
}
