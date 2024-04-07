package com.example.learning_system.service.impl;

import com.example.learning_system.mapper.DeptMapper;
import com.example.learning_system.pojo.Dept;
import com.example.learning_system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }
    @Override
    public void delete(Integer id){
        deptMapper.delete(id);
    }

    @Override
    public void insert(Dept dept) {
        //实体类中只有一个属性赋值了，把另外两个属性补充上
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
}
