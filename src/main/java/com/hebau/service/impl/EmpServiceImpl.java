package com.hebau.service.impl;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hebau.mapper.EmpExprMapper;
import com.hebau.mapper.EmpMapper;
import com.hebau.pojo.Emp;
import com.hebau.pojo.EmpExpr;
import com.hebau.pojo.EmpLog;
import com.hebau.pojo.EmpQueryParam;
import com.hebau.pojo.PageResult;
import com.hebau.service.EmpLogService;
import com.hebau.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        Integer start = (empQueryParam.getPage() - 1) * empQueryParam.getPageSize();
        empQueryParam.setStart(start);

        //1. 获取总记录数
        Long total = empMapper.count(empQueryParam);

        //2. 获取结果列表
        List<Emp> empList = empMapper.list(empQueryParam);

        //3. 封装结果
        return new PageResult<Emp>(total, empList);
    }



    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            EmpLog emplog = new EmpLog(null,LocalDateTime.now(),"新增员工"+emp);
            empLogService.insertLog(emplog);
        }

    }



    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        
        empExprMapper.deleteByEmpIds(ids);

    }



    @Override
    public Emp getInfo(Integer id) {

        return empMapper.getById(id);
    }


    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);


        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();

        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr->empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }

    }



}
