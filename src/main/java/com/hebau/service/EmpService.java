package com.hebau.service;





import java.util.List;

import com.hebau.pojo.Emp;
import com.hebau.pojo.EmpQueryParam;
import com.hebau.pojo.LoginInfo;
import com.hebau.pojo.PageResult;

public interface EmpService {

    //分页查询
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    //
    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    //员工登录
    LoginInfo Login(Emp emp);


}
