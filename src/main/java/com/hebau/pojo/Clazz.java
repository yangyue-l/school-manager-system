package com.hebau.pojo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id;
    private String name;
    private String room;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime updateTime;

    private String masterName;
    private String status;
}
