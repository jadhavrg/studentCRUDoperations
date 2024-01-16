package com.atdev.studentCRUDoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> getStudent(@RequestParam long id) 
	{
		return service.getStudent(id) ;
	}
	
	@GetMapping("/allStudent")
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent() 
	{
		return service.getAllStudent() ;
	}
}
