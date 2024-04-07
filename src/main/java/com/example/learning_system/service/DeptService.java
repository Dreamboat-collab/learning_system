package com.example.learning_system.service;

import com.example.learning_system.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void insert(Dept dept);
}
