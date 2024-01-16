package com.atdev.studentCRUDoperations.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atdev.studentCRUDoperations.dto.Student;
import com.atdev.studentCRUDoperations.repo.StudentRepo;

@Repository
public class StudentDao
{
	@Autowired
	private StudentRepo repo ;
	
	public Student saveStudent(Student student) 
	{
		return repo.save(student) ;
	}
	
	public Student getStudent(long id) 
	{
		Optional<Student> optional = repo.findById(id) ;
		
		if (optional.isEmpty()) 
		{
			return null ;
		}
		return optional.get() ;
	}
	
	public List<Student> getAllStudent() 
	{
		return repo.findAll() ;
	}
	
	public Student deleteStudent(long id) 
	{
		Optional<Student> optional = repo.findById(id) ;
		
		if (optional.isPresent()) 
		{
			repo.deleteById(id);
			return optional.get() ;
		}
		return null ;
	}
	
	public Student updateStudent(Student student, long id)
	{
		Optional<Student> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			return null ;
		}
		student.setId(id);
		return repo.save(student) ;
	}
}
