package com.cg.dao;

import com.cg.dto.LibraryDto;

public interface ILibraryDao {
	
	public LibraryDto displayDetails(String mid);
	public LibraryDto amountbalance(String mid,int payment);

}
