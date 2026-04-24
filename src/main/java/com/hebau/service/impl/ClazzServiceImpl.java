package com.hebau.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hebau.mapper.ClazzMapper;
import com.hebau.pojo.Clazz;
import com.hebau.pojo.ClazzQueryParam;
import com.hebau.pojo.PageResult;
import com.hebau.service.ClazzService;



@Service
public class ClazzServiceImpl implements ClazzService{
    

    @Autowired
    private ClazzMapper clazzMapper;
    
    //分页查询班级数据
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        Integer start = (clazzQueryParam.getPage() - 1) * clazzQueryParam.getPageSize();
        clazzQueryParam.setStart(start);

        //1. 获取总记录数
        Long total = clazzMapper.count(clazzQueryParam);

        //2. 获取结果列表
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        for (Clazz clazz : clazzList) {
            if(clazz.getEndDate().isBefore(LocalDateTime.now())){
                clazz.setStatus("已结课");
            }else{
                clazz.setStatus("未结课");
            }
        }
        //3. 封装结果
        return new PageResult<Clazz>(total, clazzList);
    }




    

}
