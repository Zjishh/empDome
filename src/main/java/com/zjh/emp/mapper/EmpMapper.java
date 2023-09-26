package com.zjh.emp.mapper;

import com.zjh.emp.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

//    /**
//     * @return {@link Long}
//     */
//    @Select("select count(*) from emp")
//    public Long count();
//
//    /**
//     * @param a
//     * @param b
//     * @return {@link List}<{@link Emp}>
//     */
//    @Select("select * from emp limit #{a},#{b}")
//    List<Emp> page(Integer a,Integer b);


    //通过分页插件实现分页员工查询
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

}
