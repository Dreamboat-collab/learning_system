package com.example.learning_system.service.impl;

import com.example.learning_system.mapper.EmpMapper;
import com.example.learning_system.pojo.Emp;
import com.example.learning_system.pojo.PageBean;
import com.example.learning_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//      Pagehelper插件
//        PageHelper.startPage(page, pageSize,true);
//        List<Emp> list = empMapper.list();
//        PageInfo<Emp> pageInfo = new PageInfo<>(list); // 使用 PageInfo 对象获取分页信息
//        int total = (int) pageInfo.getTotal(); // 获取总记录数
//        PageBean pageBean = new PageBean(total, pageInfo.getList());
//        return pageBean;

        //查询总记录数
        Integer total = empMapper.count();
        //查询数据列表
        Integer start=(page-1)*pageSize;
        List<Emp> rows=empMapper.page(start,pageSize,name,gender,begin,end);
        //将结果封装
        PageBean pageBean = new PageBean(total,rows);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.geyByUsernamePassword(emp);
    }
}
