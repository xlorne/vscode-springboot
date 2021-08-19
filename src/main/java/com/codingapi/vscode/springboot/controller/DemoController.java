package com.codingapi.vscode.springboot.controller;

import java.util.List;

import com.codingapi.vscode.springboot.entity.Demo;
import com.codingapi.vscode.springboot.repository.DemoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

    private DemoRepository demoRepository;

    @PostMapping
    public Demo save(@RequestBody Demo demo){
        demoRepository.save(demo);
        return demo;
    }

    @GetMapping
    public List<Demo> list(){
        return demoRepository.findAll();
    }
    
}
