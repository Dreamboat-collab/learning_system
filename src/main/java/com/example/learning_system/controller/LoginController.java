package com.example.learning_system.controller;

import com.example.learning_system.pojo.Emp;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result Login(@RequestBody Emp emp){
        //返回的是一个emp实体类
        Emp e = empService.login(emp);
        return e!=null?Result.success():Result.error("用户名或密码输入错误！");
    }
}
