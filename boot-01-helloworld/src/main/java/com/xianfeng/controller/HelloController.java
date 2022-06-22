package com.xianfeng.controller;

import com.xianfeng.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @Autowired
    Car car;


    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        log.info("请求进来了");
        return "hello, Spring Boot" + "您好：" + name;
    }


    @RequestMapping("/car")
    public Car car(){
        return car;
    }

}
