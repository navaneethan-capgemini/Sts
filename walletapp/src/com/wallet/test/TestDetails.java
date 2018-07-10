package com.wallet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wallet.bean.Customer;
import com.wallet.dao.Dao;
import com.wallet.service.Service;

import junit.framework.Assert;


public class TestDetails {

@Test
	public void testName(){
	
			
			 Service s1 =new Service();
					
			boolean actualReturnValue = s1.validateName("uday");
			Assert.assertEquals(false, actualReturnValue);
		
	}
@Test
public void testNumber(){
	Service s1=new Service();
	boolean actualReturnValue= s1.validateNumber("98745612300");
	Assert.assertEquals(true, actualReturnValue);
	
}
@Test
public void testPassword(){
	Service s1=new Service();
	boolean actualReturnValue=s1.validatePwd("12345678");
	Assert.assertEquals(true, actualReturnValue);
			
}
@Test
public void testAddDetailsPass(){
	Customer c=new Customer();
	Service s1=new Service();
	Dao d1=new Dao();
	c.setCname("uday");
	c.setMob_num("9502786048");
	c.setAccno(1002);
	c.setBalance(100);
	//c.setPwd("12365478");
	boolean actualReturnValue=d1.Create_acc(1000, c);
	Assert.assertEquals(true, actualReturnValue);
	
}

}
