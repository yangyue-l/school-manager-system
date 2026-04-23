package com.hebau.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hebau.pojo.Emp;
import com.hebau.pojo.EmpQueryParam;
import com.hebau.pojo.PageResult;
import com.hebau.pojo.Result;
import com.hebau.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //分页查询
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询,参数:{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }
    

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数:{}",emp);
        empService.save(emp);
        return Result.success();
    }

}
