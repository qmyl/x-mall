package com.xmall.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AccountServiceApplication {

    @GetMapping("accout")
    public String hello(){
        return "hello accout service";
    }

    public static void main(String[] args){
        SpringApplication.run(AccountServiceApplication.class,args);
    }
}
