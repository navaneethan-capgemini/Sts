package com.cg.exception;

public class LibraryException extends Exception {
	
	public LibraryException()
	{
		super();
	}
	public LibraryException(String msg)
	{
		System.out.println(msg);
	}
}
