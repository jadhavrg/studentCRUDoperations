package com.atdev.studentCRUDoperations.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
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
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		List<ObjectError> errors = ex.getAllErrors() ;
		Map<String, String> map = new HashMap<>() ;
		
		for(ObjectError objectError:errors)
		{
			FieldError error = (FieldError) objectError ;
			String field = error.getField() ;
			String message = error.getDefaultMessage() ;
			map.put(field, message) ;
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST) ;
	}
	
}
