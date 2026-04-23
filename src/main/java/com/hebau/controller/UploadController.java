package com.hebau.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hebau.pojo.Result;
import com.hebau.utils.AliyunOSSOperator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UploadController {
    
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException, Exception{
        log.info("文件上传:{}",file.getOriginalFilename());

        String url = aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("文件上传OSS:{}",url);
        return Result.success(url);
    }
}
