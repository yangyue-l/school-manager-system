package com.hebau.service;

import java.util.List;

import com.hebau.pojo.Dept;

public interface DeptService {

    //查询所有的部门数据
    
    List<Dept> findAll();

    void deleteByName(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);

}
