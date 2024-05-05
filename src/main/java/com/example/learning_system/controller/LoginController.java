package com.example.learning_system.controller;

import com.example.learning_system.pojo.Emp;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.service.EmpService;
import com.example.learning_system.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //可以将返回的Result对象自动转为json格式的数据
public class LoginController {
    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result Login(@RequestBody Emp emp){
        //返回的是一个emp实体类
        Emp e = empService.login(emp);
        //表明存在该用户
        if(e!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
