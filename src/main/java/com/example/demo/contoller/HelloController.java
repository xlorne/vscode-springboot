package com.example.demo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class HelloController {

    @GetMapping
    public String hello(){        
        log.info("hello time :{}",System.currentTimeMillis());
        return "hello";
    }
    
}
