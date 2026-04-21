package com.hebau.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hebau.mapper.DeptMapper;
import com.hebau.pojo.Dept;
import com.hebau.service.DeptService;


@Service
public class DeptServiceImpl implements DeptService{
    
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }


    @Override
    public void deleteByName(Integer id) {
        deptMapper.deleteById(id);
    }


    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }


    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }


    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}
