package com.atdev.studentCRUDoperations.util;

import lombok.Data;

@Data
public class ResponseStructure <T>
{
	private String message ;
	private int status ;
	private T data ;

}
