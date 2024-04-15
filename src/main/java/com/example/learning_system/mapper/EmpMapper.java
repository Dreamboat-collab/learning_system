package com.example.learning_system.mapper;

import com.example.learning_system.pojo.Emp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    原始分页查询
    @Select("SELECT count(*) FROM tlias.emp")
    Integer count();

//    @Param 注解用于给方法的参数提供一个特定的名字,当你的方法有两个以上的参数时，MyBatis 默认使用 arg0, arg1, arg2 等作为默认参数名;@Param("start") 注解将方法的第一个参数 Integer start 的值与SQL映射中的 #{start} 占位符关联起来
    List<Emp> page(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    void delete(@Param("ids") List<Integer> ids);

    void insert(Emp emp);

    @Select("SELECT * FROM tlias.emp WHERE id=#{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    //PageHelper分页查询
//    @Select("SELECT * FROM tlias.emp")
//    List<Emp> list();
}
