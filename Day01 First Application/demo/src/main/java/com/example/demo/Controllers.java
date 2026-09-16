package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/bay")
    public String bay(){
        return "<h1>Bay Bay</h1>";
    }
}
