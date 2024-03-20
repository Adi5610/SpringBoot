package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    //constructor injection
    public MyFirstService(MyFirstApp myFirstApp) {
        this.myFirstApp = myFirstApp;
    }

    //filed injection
    //@Autowired
    MyFirstApp myFirstApp;

    public String tellStory(){
        return "from firstAppService calling myFirstApp => " + myFirstApp.hello();
    }
}
