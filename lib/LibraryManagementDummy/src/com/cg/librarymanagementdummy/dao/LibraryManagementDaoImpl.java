package com.cg.librarymanagementdummy.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.librarymanagementdummy.dto.Person;

public class LibraryManagementDaoImpl implements ILibraryManagementDao {

	private static Map<String, Person> myMap = null;
	static {
		myMap = new HashMap<>();
		Person person1 = new Person("1000", "Vikash Kumar", "10");
		Person person2 = new Person("1001", "Vivek Singh", "100");
		Person person3 = new Person("1002", "Ajay Kumar", "-200");
		Person person4 = new Person("1003", "Vishnu Kumar", "0");
		myMap.put(person1.getMemberId(), person1);
		myMap.put(person2.getMemberId(), person2);
		myMap.put(person3.getMemberId(), person3);
		myMap.put(person4.getMemberId(), person4);
		
		/*Iterator<Entry<String, Person>> entries = myMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, Person> entry = entries.next();
		    System.out.println("Key = " + entry.getKey() + ", Value = " +myMap.get(entry.getKey()).getAmount());
		 
		}
		*/
	}

	@Override
	public Person checkPerson(String memberId) {
		return myMap.get(memberId);
	}

	 
	/*
	 
	 */
}
