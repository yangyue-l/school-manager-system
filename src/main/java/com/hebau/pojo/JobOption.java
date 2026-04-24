package com.hebau.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    private List jobList;//职位列表
    private List dataList;//数据列表
}
