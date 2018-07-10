package com.cg.librarymanagementdummy.service;

import com.cg.librarymanagementdummy.dao.ILibraryManagementDao;
import com.cg.librarymanagementdummy.dao.LibraryManagementDaoImpl;
import com.cg.librarymanagementdummy.dto.Person;
import com.cg.librarymanagementdummy.exception.ILibraryManagementExceptionMessages;
import com.cg.librarymanagementdummy.exception.LibraryManagementException;

public class LibraryManagementServiceImpl implements ILibraryManagementService {

	ILibraryManagementDao dao = null;

	public LibraryManagementServiceImpl() {
		dao = new LibraryManagementDaoImpl();
	}

	@Override
	public boolean validatedetails(String memberId) throws LibraryManagementException {
		boolean result = true;
		if (!(memberId.matches("^[0-9A-za-z]+$"))) {
			throw new LibraryManagementException(ILibraryManagementExceptionMessages.MESSAGE1);

		}
		return result;
	}

	@Override
	public Person viewMembers(String memberId) {
		Person person = null;
		person = dao.checkPerson(memberId);
		return person;
	}

	@Override
	public boolean validateAmount(String amount) throws LibraryManagementException {
		boolean result = true;
		if (!(amount.matches("^\\d+.\\d{1,}$"))) {
			throw new LibraryManagementException(ILibraryManagementExceptionMessages.MESSAGE2);

		}
		return result;
	}

	@Override
	public String addAmount(String memberid, String amount) {
		Person person = null;
		person = dao.checkPerson(memberid);
		if (person != null) {
			long amt = Long.parseLong(amount) + Long.parseLong(person.getAmount());
			person.setAmount(String.valueOf(amt));
		}
		return person.getAmount();
	}

}
