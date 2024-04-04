package com.example.demo.restImpl.repository;

import com.example.demo.restImpl.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
