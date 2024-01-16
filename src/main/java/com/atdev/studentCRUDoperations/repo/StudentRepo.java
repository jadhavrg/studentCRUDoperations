package com.atdev.studentCRUDoperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atdev.studentCRUDoperations.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Long>
{
	
}
