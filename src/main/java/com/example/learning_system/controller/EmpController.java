package com.example.learning_system.controller;

import com.example.learning_system.pojo.Emp;
import com.example.learning_system.pojo.PageBean;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;
    //分页条件查询员工信息
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        PageBean pageBean  = empService.list(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    //批量删除员工
    @DeleteMapping("/{ids}")
    //将前端传递的ids封装至数组
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    //新增员工    使用Emp实体类封装前端传递的json格式数据
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        empService.insert(emp);
        return Result.success();
    }

    //编辑员工信息时，将该员工信息回显
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp =  empService.getById(id);
        return Result.success(emp);
    }

    //编辑员工信息时，修改员工数据     @RequestBody用于从请求体中获取json格式数据，用实体类进行封装
    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}

