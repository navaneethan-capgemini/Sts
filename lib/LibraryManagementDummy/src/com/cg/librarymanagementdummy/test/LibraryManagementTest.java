package com.cg.librarymanagementdummy.test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.librarymanagementdummy.exception.LibraryManagementException;
import com.cg.librarymanagementdummy.service.ILibraryManagementService;
import com.cg.librarymanagementdummy.service.LibraryManagementServiceImpl;

public class LibraryManagementJunitTest {

	ILibraryManagementService service = new LibraryManagementServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Starts...");
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		System.out.println("Testing Ends...");
	}

	@Test
	public void testValidatedetails() throws LibraryManagementException {
		boolean result = service.validatedetails("1000");
		assertTrue(result);
	}

	@Test
	public void testValidateAmount() throws LibraryManagementException {
		boolean result = service.validatedetails("12345");
		assertTrue(result);
	}

	@Test
	public void testAddAmount() {
		String resultActual = service.addAmount("1003", "3000");
		String resultExpected = "2000";
		assertNotSame(resultExpected.trim(), resultActual.trim());
	}

}
