package com.tdgames.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdgames.students.entity.Student;
import com.tdgames.students.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService stService;
	
	@GetMapping("/allStudents")
	public List<Student> listAll(){
		return stService.findAll();
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student) {
		stService.saveStudent(student);
		return ""+HttpStatus.OK;
	}
	
	@PutMapping("/updateStudent")
	public String update(@RequestBody Student student) {
		stService.updateStudent(student);
		return ""+HttpStatus.OK;
	}
}
