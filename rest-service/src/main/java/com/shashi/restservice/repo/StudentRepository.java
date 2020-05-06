package com.shashi.restservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashi.restservice.model.Student;

/*
 * author: Shashi
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
