package com.example.learning_system.mapper;

import com.example.learning_system.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    //查询的结果存储在List<Dept>集合中
    @Select("select * FROM tlias.dept")
    List<Dept> list();

    @Delete("DELETE FROM tlias.dept WHERE id=#{id}")
    void delete(Integer id);

    @Insert("INSERT INTO tlias.dept(name, create_time, update_time) VALUES(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
