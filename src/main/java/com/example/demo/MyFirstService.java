package com.example.demo;

import com.example.demo.MyFirstApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {


    // for application.properties no need specify classpath
    @Value("${my.name}")
    private String myName;

    //for custom properties class path is required
    @Value("${custom.my.name}")
    private String customName;




    //filed injection
    //@Autowired
    MyFirstApp myFirstApp;

    //constructor injection
    public MyFirstService(MyFirstApp myFirstApp) {
        this.myFirstApp = myFirstApp;
    }
    public String getMyName() {
        return myName;
    }

    public String getCustomName() {
        return customName;
    }



    public String tellStory(){
        return "from firstAppService calling myFirstApp => " + myFirstApp.hello();
    }
}
