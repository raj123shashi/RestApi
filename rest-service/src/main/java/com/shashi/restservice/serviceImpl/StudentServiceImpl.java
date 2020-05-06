package com.shashi.restservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.restservice.model.Student;
import com.shashi.restservice.repo.StudentRepository;
import com.shashi.restservice.service.StudentService;

/*
 * author:Shashi
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student getByStudentId(Integer id) {
		
		return studentRepo.getOne(id);
	}

	@Override
	public Student updateStudentById(Integer id, Student student) {
		 Student st = studentRepo.getOne(id);
		 st.setBranch(st.getBranch());
		 st.setFirstName(st.getFirstName());
		 st.setLastName(st.getLastName());
		return st;
	}

	@Override
	public boolean deleteStudentById(Integer id) {
		
		studentRepo.deleteById(id);
		return true;
	}

}
