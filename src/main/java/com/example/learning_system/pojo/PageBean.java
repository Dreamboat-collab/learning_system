package com.example.learning_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.learning_system.pojo.Emp;

import java.util.List;

//返回给前端的结果：总记录数以及数据列表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private int total;
    private List rows;
}
