package com.example.demo.restImpl.repository;

import com.example.demo.restImpl.models.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile,Integer> {
}
