package com.hebau.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hebau.pojo.Clazz;
import com.hebau.pojo.ClazzQueryParam;

@Mapper
public interface ClazzMapper {

    @Select("select count(*) from clazz")
    Long count(ClazzQueryParam clazzQueryParam);

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

}
