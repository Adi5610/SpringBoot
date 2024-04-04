package com.example.demo.restImpl.controller;

import com.example.demo.restImpl.dto.ResponseStudentDto;
import com.example.demo.restImpl.dto.StudentDto;
import com.example.demo.restImpl.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentService studentService;


    public FirstController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseStudentDto createStudent(
            @RequestBody StudentDto dto
    ) {
        return studentService.SaveStudent(dto);
    }



    @GetMapping("/students")
    public List<ResponseStudentDto> findAllStudents()
    {

        return studentService.findAll();
    }



    @GetMapping("/students/{student-id}")
    public ResponseStudentDto findStudent(
            @PathVariable("student-id") Integer id
    )
    {
        return studentService.findById(id).orElse(null);

    }

    @GetMapping("/students/search/{student-name}")
    public List<ResponseStudentDto> findStudentByFirstName(
            @PathVariable("student-name") String name
    )
    {
        return studentService.findAllByFirstName(name);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteStudentById(
            @PathVariable("student-id") Integer id
    )
    {
        studentService.deleteById(id);
    }




/*
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

     */


}
