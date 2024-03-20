package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//configuration annotation describe, it contains bean method
@Configuration
public class ApplicationConfig {

    //this bean will be instantiated
    @Bean
    //@Qualifier("bean1")
    public MyFirstApp myFirstApp(){
        return new MyFirstApp("hello first bean");
    }

    @Bean
    //@Qualifier("bean2")
    public MyFirstApp mySecondApp(){
        return new MyFirstApp("hello second bean");
    }

    @Bean
    //@Qualifier("bean3")
    @Primary
    public MyFirstApp myThirdApp(){
        return new MyFirstApp("hello third bean");
    }
}
