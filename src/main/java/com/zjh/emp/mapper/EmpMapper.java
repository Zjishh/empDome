package com.zjh.emp.mapper;

import com.zjh.emp.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) value (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getbyid(Integer id);

    void update(Emp emp);

    @Select("select * from  emp where username = #{username} and password = #{password}")
    Emp getbyidandpassword(Emp emp);


    /**
     * 根据部门删除员工
     * @param emp
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
