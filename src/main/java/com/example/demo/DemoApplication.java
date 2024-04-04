package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(DemoApplication.class, args);

		//MyFirstApp myFirstApp = ctx.getBean(MyFirstApp.class);
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getMyName());
		System.out.println(myFirstService.getCustomName());

	}

}
