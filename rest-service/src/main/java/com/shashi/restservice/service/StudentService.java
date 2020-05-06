package com.shashi.restservice.service;

import java.util.List;

import com.shashi.restservice.model.Student;

/*
 * author:Shashi
 */

public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student getByStudentId(Integer id);
	
	public Student updateStudentById(Integer id, Student student);
	
	public boolean deleteStudentById(Integer id);

}
