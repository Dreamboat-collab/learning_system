package com.example.learning_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data注解是Lombok项目提供的一个注解，用于自动生成Java类中的常用方法，如toString()、equals()、hashCode()以及所有属性的getter和setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;  //响应码
    private String mas;    //响应信息
    private Object data;   //返回的数据

    //无参数的成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }
    //有参数的成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    public static Result error(String msg){
        return new Result(1,msg,null);
    }

}
