package com.cg.tentwoone.testcase;

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.tentwoone.ui.Person;


public class TestClass {
	private static Person p = null;

	@BeforeClass
	public static void beforeClass() {
		p = new Person();
	}

	@Test
	public void test1() {
		p.setFirstName("krishna");

	}
	
	@Test
	public void test2() {
		p.setLastName("Mutyala");

	}
	
	@Test
	public void test3() {
		p.setG('M');	
	}
	
	@Test
	public void test4() {
	String s=p.getLastName();
	assertSame("Mutyala", s);

	}
	@Test
	public void test5() {
	String s=p.getFirstName();
	assertSame("krishna", s);

	}
	@Test
	public void test6() {
	char s=p.getG();
	assertSame('M', s);

	}
	

}

