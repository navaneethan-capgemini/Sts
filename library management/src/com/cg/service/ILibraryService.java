package com.cg.service;

import com.cg.dto.LibraryDto;
import com.cg.exception.LibraryException;

public interface ILibraryService {
	
	public LibraryDto displayDetails(String mid);
	public LibraryDto amountBalance(String mid,int payment);
	public void validationdetails(String mid) throws LibraryException;

}
