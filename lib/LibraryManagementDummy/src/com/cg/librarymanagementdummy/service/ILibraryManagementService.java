package com.cg.librarymanagementdummy.service;

import com.cg.librarymanagementdummy.dto.Person;
import com.cg.librarymanagementdummy.exception.LibraryManagementException;

public interface ILibraryManagementService {
	public boolean validatedetails(String memberId) throws LibraryManagementException;

	public Person viewMembers(String memberId);

	public boolean validateAmount(String amount) throws LibraryManagementException;

	public String addAmount(String memberid, String amount);
}
