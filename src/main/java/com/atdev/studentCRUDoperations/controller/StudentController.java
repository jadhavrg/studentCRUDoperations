package com.atdev.studentCRUDoperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.studentCRUDoperations.dto.Student;
import com.atdev.studentCRUDoperations.service.StudentService;
import com.atdev.studentCRUDoperations.util.ResponseStructure;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService service ;
	
	@PostMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) 
	{
		return service.saveStudent(student) ;
	}
}
