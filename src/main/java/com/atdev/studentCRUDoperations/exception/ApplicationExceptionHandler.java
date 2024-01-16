package com.atdev.studentCRUDoperations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atdev.studentCRUDoperations.util.ResponseStructure;


@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student with given Id is not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(DataNotFound.class)
	public ResponseEntity<ResponseStructure<String>> dataNotFoundExceptionHandler(DataNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Please add the student first..!!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
	
	
}
