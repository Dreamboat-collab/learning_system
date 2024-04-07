package com.example.learning_system.service;

import com.example.learning_system.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpService {
    PageBean list(Integer page,Integer pageSize);
}
