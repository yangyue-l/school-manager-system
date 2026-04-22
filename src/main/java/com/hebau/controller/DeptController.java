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
import org.springframework.web.bind.annotation.RestController;

import com.hebau.pojo.Dept;
import com.hebau.pojo.Result;
import com.hebau.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts",method = RequestMethod.GET)
    //查询全部部门
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }

    //删除部门
    @DeleteMapping
    public Result delete(Integer id){
        log.info("根据id删除部门:{}" , id);
        deptService.deleteByName(id);
        return Result.success();
    }

    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据Id查询部门
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据Id查询部门:{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门基本信息
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
