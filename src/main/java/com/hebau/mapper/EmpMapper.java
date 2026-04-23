package com.hebau.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.hebau.pojo.Emp;
import com.hebau.pojo.EmpQueryParam;

//员工基本信息
@Mapper
public interface EmpMapper {

    //查询总记录数
    Long count(EmpQueryParam empQueryParam);

    //分页查询员工信息
    List<Emp> list(EmpQueryParam empQueryParam);
    //新增员工基本信息
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into  emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" + 
                "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);




}
