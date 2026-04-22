package com.hebau.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hebau.pojo.Emp;

//员工基本信息
@Mapper
public interface EmpMapper {

    //查询总记录数
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();

    //分页查询员工信息
    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
    List<Emp> list(Integer start,Integer pageSize);




}
