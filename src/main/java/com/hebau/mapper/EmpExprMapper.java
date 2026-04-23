package com.hebau.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hebau.pojo.EmpExpr;

//员工工作经历

@Mapper
public interface EmpExprMapper {

    //批量保存员工工作经历
    
    void insertBatch(List<EmpExpr> exprList);

    //根据员工Id批量删除员工
    void deleteByEmpIds(List<Integer> empIds);





}
