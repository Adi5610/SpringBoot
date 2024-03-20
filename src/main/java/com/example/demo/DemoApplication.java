package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(DemoApplication.class, args);

		//MyFirstApp myFirstApp = ctx.getBean(MyFirstApp.class);
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.print(myFirstService.tellStory());

	}

}
