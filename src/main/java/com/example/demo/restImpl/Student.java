package com.example.demo.restImpl;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    private String firtsName;
    private String lastName;
    @Column(
            unique = true
    )
    private String email;
    private int age;
    public Student() {
    }

    public Student(String firtsName, String lastName, String email, int age) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
