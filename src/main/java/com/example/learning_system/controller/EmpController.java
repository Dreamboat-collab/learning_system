package com.example.learning_system.controller;

import com.example.learning_system.pojo.PageBean;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/emps")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean pageBean  = empService.list(page,pageSize);
        return Result.success(pageBean);
    }
}
