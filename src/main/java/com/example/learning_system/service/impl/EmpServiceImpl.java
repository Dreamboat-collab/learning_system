package com.example.learning_system.service.impl;

import com.example.learning_system.mapper.EmpMapper;
import com.example.learning_system.pojo.Emp;
import com.example.learning_system.pojo.PageBean;
import com.example.learning_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize) {
        //查询总记录数
        Integer total = empMapper.count();
        //查询数据列表
        Integer start=(page-1)*pageSize;
        List<Emp> rows=empMapper.page(start,pageSize);
        //将结果封装
        PageBean pageBean = new PageBean(total,rows);
        return pageBean;
    }
}
