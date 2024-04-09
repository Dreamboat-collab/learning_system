package com.example.learning_system.controller;

import com.example.learning_system.pojo.PageBean;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/emps")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        PageBean pageBean  = empService.list(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }
}
