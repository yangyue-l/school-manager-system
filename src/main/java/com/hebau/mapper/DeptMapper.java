package com.hebau.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hebau.pojo.Dept;

@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    //根据Id查询部门数据
    @Select("select id,name,create_time,update_time from dept where id = #{id}")
    Dept getById(Integer id);

    //更新部门数据
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
    

}
