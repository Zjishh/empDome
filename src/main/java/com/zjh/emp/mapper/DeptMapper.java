package com.zjh.emp.mapper;

import com.zjh.emp.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询苏头
     * @return {@link List}<{@link Dept}>
     */
    @Select("SELECT * FROM dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void deletebyid(Integer id);

    @Insert("insert into dept (name,create_time,update_time) value (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("SELECT * FROM dept where id = #{id}")
    Dept listbyid(Integer id);

    @Update("update dept set name = #{name},create_time = #{createTime} where id =  #{id}")
    void update(Dept dept);
}
