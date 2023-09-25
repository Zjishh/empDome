package com.zjh.emp.service.impl;

import com.zjh.emp.mapper.DeptMapper;
import com.zjh.emp.pojo.Dept;
import com.zjh.emp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired(required=false)
    private DeptMapper deptMapper;


    /**
     *
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public Dept listbyid(Integer id) {
        return deptMapper.listbyid(id);
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deletebyid(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
