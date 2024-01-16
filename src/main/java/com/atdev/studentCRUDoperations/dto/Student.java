package com.atdev.studentCRUDoperations.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String firstName ;
	private String lastName ;
	private String email ;
	private long phone ;
	private String address ;
	private int marksObtained ;
	private int totalMarks ;
	private double percentage ;
	private String grade ;
}
