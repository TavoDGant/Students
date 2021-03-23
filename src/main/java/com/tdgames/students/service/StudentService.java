package com.tdgames.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tdgames.students.entity.Student;
import com.tdgames.students.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public void saveStudent(Student student) {
		studentRepository.save(student);		
	}
	
	public List<Student> updateStudent(Student student) {
		studentRepository.save(student);
		return findAll();
	}

	public String deleteStudent(Integer id) {
		System.out.println(id);
		if(studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
			return ""+HttpStatus.OK;
		}else {			
			return ""+HttpStatus.NOT_FOUND;
		}
	}
}
