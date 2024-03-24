package com.example.demo.restImpl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    //@GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHello(){
        return "hello form rest api";
    }

    @PostMapping("/hello")
    public String postMessage(
           @RequestBody String message
    ){
        return "hello "+ message;
    }

    @PostMapping("/order")
    public String postOrder(
            @RequestBody Order order
    ){
        return "your order is "+ order.toString();
    }

    @PostMapping("/order-record")
    public String postOrderRecord(
            @RequestBody OrderRecord orderRecord
    ){
        return "your order is "+ orderRecord.toString();
    }

    // https://localhost:8080/hello/aditya
    @GetMapping("/hello/{user-name}")
    @ResponseStatus(HttpStatus.OK)
    public String getHelloUser(
            @PathVariable("user-name") String userName
    ){
        return "hello "+ userName;
    }

    // https://localhost:8080/hello/aditya
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHelloUserparam(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastName") String userLastName
    ){
        return "hello "+ userName + " " + userLastName;
    }
}
