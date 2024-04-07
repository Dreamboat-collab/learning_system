package com.example.learning_system.mapper;

import com.example.learning_system.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT count(*) FROM tlias.emp")
    Integer count();

    @Select("SELECT * FROM tlias.emp LIMIT #{start}, #{pageSize}")
    List<Emp> page(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
}
