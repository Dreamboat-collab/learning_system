package com.example.learning_system.controller;

import com.example.learning_system.pojo.Dept;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查询部门
    @GetMapping("/depts")
    public Result list(){
        List<Dept> result = deptService.list();
        return Result.success(result);
    }

    //删除部门
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);
        return Result.success();
    }

    //新增部门,@RequestBody：可以将请求体中的数据封装到实体类中
    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept){
        deptService.insert(dept);
        return Result.success();
    }
}
