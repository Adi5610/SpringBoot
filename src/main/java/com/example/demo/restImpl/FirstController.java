package com.example.demo.restImpl;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public ResponseStudentDto post(
            @RequestBody StudentDto dto
    ) {
        var student = toStudent(dto);
        var savedStudent = repository.save(student);
        return toResponseStudentDto(savedStudent);
    }

    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstname());
        student.setLastName(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;

    }
    private ResponseStudentDto toResponseStudentDto(Student student){

        return new ResponseStudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );

    }

    @GetMapping("/students")
    public List<Student> findAllStudents()
    {

        return repository.findAll();
    }



    @GetMapping("/students/{student-id}")
    public Optional<Student> findStudent(
            @PathVariable("student-id") Integer id
    )
    {
        return repository.findById(id);

    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByFirstName(
            @PathVariable("student-name") String name
    )
    {
        return repository.findAllByFirstNameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteStudentById(
            @PathVariable("student-id") Integer id
    )
    {
        repository.deleteById(id);
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
