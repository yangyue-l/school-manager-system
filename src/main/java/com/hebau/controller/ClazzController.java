package com.hebau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hebau.pojo.Clazz;
import com.hebau.pojo.ClazzQueryParam;
import com.hebau.pojo.PageResult;
import com.hebau.pojo.Result;
import com.hebau.service.ClazzService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result getClazzById(ClazzQueryParam clazzQueryParam){
        log.info("分页查询班级数据");
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam); 
        return Result.success(pageResult);
    }

}
