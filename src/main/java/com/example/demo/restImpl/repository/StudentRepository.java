package com.example.demo.restImpl.repository;

import com.example.demo.restImpl.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    List<Student> findAllByFirstNameContaining(String name);

}
