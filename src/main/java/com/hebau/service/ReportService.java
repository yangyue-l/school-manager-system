package com.hebau.service;

import java.util.List;
import java.util.Map;

import com.hebau.pojo.JobOption;

public interface ReportService {

    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();


}
