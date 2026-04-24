package com.hebau.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hebau.pojo.Emp;
import com.hebau.pojo.LoginInfo;
import com.hebau.pojo.Result;
import com.hebau.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result Login(@RequestBody Emp emp){
        log.info("登录:{}",emp);
        LoginInfo info = empService.Login(emp);
        if(info != null){
            return Result.success(info);
        }else{
            return Result.error("用户名或密码错误");
        }
    }



    
}
