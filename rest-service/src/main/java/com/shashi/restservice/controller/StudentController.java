package com.shashi.restservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.restservice.model.Student;
import com.shashi.restservice.service.StudentService;

/*
 * author:Shashi
 */
@RestController
@RequestMapping("/FirstApi/v1")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
	  this.studentService = studentService;
	}
	
	@PostMapping(path="/newStudent", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		  if (StringUtils.isEmpty(student) || student == null) {
			    return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			  }
		Student st = studentService.saveStudent(student);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@GetMapping(path="/students", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> stList = studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(stList, HttpStatus.OK);
	}
	
	@GetMapping(path="/student/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		 if (StringUtils.isEmpty(id) || id == null) {
			    return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			  }
		 Student stu = studentService.getByStudentId(id);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	
	
	@PutMapping(path="/student/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Student> updateStudentById(@PathVariable Integer id, @RequestBody Student student){
		 if (StringUtils.isEmpty(id) || id == null) {
			  if(StringUtils.isEmpty(student) || student == null) {
				  return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			    }  
			  }
		 Student stu = studentService.getByStudentId(id);
		 stu.setFirstName(stu.getFirstName());
		 stu.setLastName(stu.getLastName());
		 stu.setBranch(stu.getBranch());
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/student/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> deleteStudentById(@PathVariable Integer id){
		 if (StringUtils.isEmpty(id) || id == null) {
			    return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			  }
		 studentService.deleteStudentById(id);
		return new ResponseEntity<>("Deleted Studennt Successfully", HttpStatus.OK);
	}
	
	

}
