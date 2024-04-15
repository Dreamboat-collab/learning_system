package com.example.learning_system.controller;

import com.example.learning_system.pojo.Result;
import com.example.learning_system.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Autowired
    public AliOSSUtils aliOSSUtils;
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
//        //获取用户上传的原始文件吗
//        String originalFilename = image.getOriginalFilename();
//        //截取文件名的后缀，拼接至uuid上
//        int index = originalFilename.lastIndexOf(".");
//        //后缀名,substring表示获取指定索引后的字符
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString()+extname;
//
//        //将文件存储在本地磁盘
//        image.transferTo(new File("E:\\images\\"+newFileName));
//        return Result.success();
//    }
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
