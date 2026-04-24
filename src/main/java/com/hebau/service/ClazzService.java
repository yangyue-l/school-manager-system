package com.hebau.service;

import com.hebau.pojo.Clazz;
import com.hebau.pojo.ClazzQueryParam;
import com.hebau.pojo.PageResult;

public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);



    
}
