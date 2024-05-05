package com.example.learning_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 这个注解会启用 Servlet/Filter 的自动扫描
@SpringBootApplication
public class LearningSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSystemApplication.class, args);
    }

}
