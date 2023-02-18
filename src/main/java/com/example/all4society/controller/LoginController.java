package com.example.all4society.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class LoginController {
    final private static Logger LOG = Logger.getGlobal();
    public static final String SECURED_TEXT = "Hello from the secured resource!";


    @GetMapping ("login")
    public void login(){
        LOG.info("GET sucessfully called on /login resource");
    }

    // 테스트용
    @GetMapping("/hello")
    public void hello() {
        System.out.println("HelloWorld");
    }
}
