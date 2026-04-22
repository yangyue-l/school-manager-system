package com.hebau.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hebau.mapper.EmpMapper;
import com.hebau.pojo.Emp;
import com.hebau.pojo.PageResult;
import com.hebau.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long total = empMapper.count();

        //2. 获取结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize);

        //3. 封装结果
        return new PageResult<>(total, empList);
    }


}
