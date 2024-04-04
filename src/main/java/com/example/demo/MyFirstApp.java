package com.example.demo;


import org.springframework.stereotype.Component;

@Component
public class MyFirstApp {

    public String var;

    public MyFirstApp(String var) {

        this.var = var;
    }

    public String hello(){
        return "you did it! " + var;
    }
}
