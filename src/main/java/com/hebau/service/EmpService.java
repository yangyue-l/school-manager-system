package com.hebau.service;





import com.hebau.pojo.Emp;
import com.hebau.pojo.EmpQueryParam;
import com.hebau.pojo.PageResult;

public interface EmpService {

    //分页查询
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    //
    void save(Emp emp);


}
