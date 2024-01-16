package com.atdev.studentCRUDoperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atdev.studentCRUDoperations.dao.StudentDao;
import com.atdev.studentCRUDoperations.dto.Student;
import com.atdev.studentCRUDoperations.util.ResponseStructure;

@Service
public class StudentService
{
	@Autowired
	private StudentDao dao ;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) 
	{
		int marksObtained = student.getMarksObtained() ;
		int totalMarks = student.getTotalMarks() ;
		
		double percentage = (marksObtained *100 / totalMarks) ;
		student.setPercentage(percentage) ;
		
		if (percentage < 35) 
		{
			student.setGrade("Fail") ;
		}
		else if (percentage>=35 && percentage<50)
		{
			student.setGrade("Pass") ;
		}
		else if(percentage>=50 && percentage<65)
		{
			student.setGrade("C") ;
		}
		else if(percentage>=65 && percentage<90)
		{
			student.setGrade("B") ;
		}
		else if(percentage>=90)
		{
			student.setGrade("A") ;
		}
		
		ResponseStructure<Student> structure = new ResponseStructure<>() ;
		structure.setMessage("Student is saved successfully..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student));
		
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED) ;
		
	}
	
	public ResponseEntity<ResponseStructure<Student>> getStudent(long id) 
	{
		 ResponseStructure<Student> structure = new ResponseStructure<>() ;
		 
		 if(structure != null)
		 {
			 structure.setMessage("Student is found successfully..!");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dao.getStudent(id));
			 return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND) ;
		 }
		 
		 return null ;
	}
	
	
//	public ResponseEntity<ResponseEntity<List<Student>>> getAllStudent() 
//	{
//		
//	}
}
