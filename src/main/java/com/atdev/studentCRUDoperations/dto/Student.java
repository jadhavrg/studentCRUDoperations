package com.atdev.studentCRUDoperations.dto;


import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@NotBlank(message = "First Name can't be blank")
	@NotNull(message = "First Name can't be null")
	private String firstName ;
	@NotBlank(message = "Last Name can't be blank")
	@NotNull(message = "Last Name can't be null") 
	private String lastName ;
	@Column(unique = true)
	@NotBlank(message = "Email can't be blank")
	@NotNull(message = "Email can't be null")
	@Email(regexp = "[a-z0-9.$%_+]+@[a-z0-9]+\\.[a-z]{2,3}" , message = "Invalid Message")
	private String email ;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone ;
	@NotBlank(message = "Address can't be blank")
	@NotNull(message = "Address can't be null")
	private String address ;
	@Min(value = 1)
	@Max(value = 600)
	private int marksObtained ;
	@Value("600")
	private int totalMarks ;
	private double percentage ;
	private String grade ;
}
