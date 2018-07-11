package com.cg.tentwo.Testcase;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.tentwo.ui.MyDate;

public class DateTest {
	@BeforeClass
	public static void c() {
		System.out.println("Start");
	}
	
	@AfterClass
	public static void d() {
		System.out.println("End");
	}
		
		@Test
		public void test1() {
			MyDate d = new MyDate();
			d.setDay(10);
			int d1 = d.getDay();
			assertEquals(10, d1);
			
		}
		@Test
		public void test2() {
			MyDate d = new MyDate();
			d.setMonth(10);
			int d1 = d.getMonth();
			assertEquals(10, d1);
			
		}
		
		@Test
		public void test3() {
			MyDate d = new MyDate();
			d.setYear(2005);
			int d1 = d.getYear();
			assertEquals(2005, d1);
			
		}
		
		@Test
		public void test4() {
			MyDate d = new MyDate(8,10,1997);
			String d1 = d.toString();
			assertEquals(("Date is 8/10/1997"), d1);
			
		}
		
	

}
