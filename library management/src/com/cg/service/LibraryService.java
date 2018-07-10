package com.cg.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.dao.ILibraryDao;
import com.cg.dao.LibraryDao;
import com.cg.dto.LibraryDto;
import com.cg.exception.ILibraryException;
import com.cg.exception.LibraryException;

public class LibraryService implements ILibraryService {

	ILibraryDao dao=new LibraryDao();
	LibraryDto dto=new LibraryDto();
	
	@Override
	public LibraryDto displayDetails(String mid) {
		// TODO Auto-generated method stub
		return dao.displayDetails(mid);
	}

	@Override
	public LibraryDto amountBalance(String mid, int payment) {
		// TODO Auto-generated method stub
		
		return dao.amountbalance(mid, payment);
	}

	@Override
	public void validationdetails(String mid) throws LibraryException {
		// TODO Auto-generated method stub
	
	Pattern pattern = Pattern.compile("^[0-9a-zA-Z]+$");
	Matcher matcher = pattern.matcher((mid));
	if(!(matcher.matches())) {
		throw new LibraryException(ILibraryException.Message1);
	}
	
	/*	if(!(dto.getName().matches("[a-zA-Z]+")))
		{
			throw new LibraryException(ILibraryException.Message2);
		}
		
		if(!(String.valueOf(dto.getBalance()).matches("[0-9]+")))
		{throw new LibraryException(ILibraryException.message3);
		}*/
		
		
	}

}
