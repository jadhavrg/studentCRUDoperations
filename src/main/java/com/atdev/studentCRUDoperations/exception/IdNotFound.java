package com.atdev.studentCRUDoperations.exception;

public class IdNotFound extends RuntimeException
{
//	String message ;
//	
//	@Override
//	public String getMessage() 
//	{
//		return message;
//	}
//	
//	public IdNotFound(String message) 
//	{
//		super() ;
//		this.message = message ;
//	}
	
String message ;
	
	@Override
	public String getMessage() 
	{
		return message ;
	}

	public IdNotFound(String message) {
		super();
		this.message = message;
	}
	
}
