package com.hebau.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    //删除员工
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    //查询员工信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询员工信息");
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    //修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息");
        empService.update(emp);

        return Result.success();
    }



}
