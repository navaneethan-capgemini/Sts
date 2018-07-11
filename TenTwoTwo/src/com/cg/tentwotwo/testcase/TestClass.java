package com.cg.tentwotwo.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.tentwotwo.dto.Employee;
import com.cg.tentwotwo.exception.EmployeeException;

public class TestClass {
	private static Employee emp = null;
	@BeforeClass
	public static void beforeClass() {
		emp = new Employee();
	}

	@Test(expected = EmployeeException.class)
	public void test1() throws EmployeeException {
		emp.setEmpSalary(1000);

	}
	@Test
	public void test2() throws EmployeeException {
		emp.setEmpSalary(4000);

	}
}
