package com.example.learning_system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LearningSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        //获取用户上传的原始文件吗
        String originalFilename = "123.jpg";
        //截取文件名的后缀，拼接至uuid上
        int index = originalFilename.lastIndexOf(".");
        //后缀名,substring表示获取指定索引后的字符
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString()+extname;
        System.out.println(newFileName);
    }

}
