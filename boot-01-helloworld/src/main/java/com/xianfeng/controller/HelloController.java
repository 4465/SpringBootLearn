package com.xianfeng.controller;

import com.xianfeng.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Car car;


    @RequestMapping("/hello")
    public String handle01(){
        return "hello, Spring Boot";
    }


    @RequestMapping("/car")
    public Car car(){
        return car;
    }

}
