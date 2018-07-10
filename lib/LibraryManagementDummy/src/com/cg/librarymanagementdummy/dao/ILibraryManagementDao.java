package com.cg.librarymanagementdummy.dao;

import com.cg.librarymanagementdummy.dto.Person;

public interface ILibraryManagementDao {

	public Person checkPerson(String memberId);
}
