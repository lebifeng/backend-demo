package com.bifengle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TestJavaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJavaProjectApplication.class, args);
    }

}
