package com.atdev.studentCRUDoperations.exception;

public class DataNotFound extends RuntimeException
{
	String message ;
	
	@Override
	public String getMessage() 
	{
		return message ;
	}
	
	public DataNotFound(String message) 
	{
		super() ;
		this.message = message ;
	}
	

}
