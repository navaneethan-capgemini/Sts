package com.wallet.service;

import java.util.ArrayList;
import java.util.Scanner;


import com.wallet.bean.Customer;
import com.wallet.exception.WalletException;
import com.wallet.dao.Dao;
import com.wallet.pl.Presentation;

public class Service implements IService{
	static String namePattern = "[A-Z]{1}[a-z]{2,}";		//name format pattern
	static String contactPattern = "[0-9]{10}";			//phone no format pattern
    static String passwordpattern ="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"; 
    Customer c=new Customer();
    Dao dataobj=new Dao();
	Scanner sc=new Scanner(System.in);
	static double accno=999.00;
	@Override
	public boolean validateName(String s) {
		// TODO Auto-generated method stub
		boolean f=false;
		if(s.matches(namePattern))
		{
		
			f=true;
			
		}

			
		return f;
			
		
	}
	@Override
	public boolean validateNumber(String n) {
		// TODO Auto-generated method stub
		boolean f=false;
		if(n.matches(contactPattern)){
		
		f=true;
		}
			return f; 
		
	}
	
	@Override
	public boolean validatePwd(String pwd) {
	// TODO Auto-generated method stub
		boolean f=false;
		if(pwd.matches(passwordpattern))
		{
		f=true;
		}
			return f;
	}
		


	public double createAcc(Customer c)
	{
		accno++;
	boolean flag=dataobj.Create_acc(accno,c);
	
	if(flag){
	
	
	return accno;
	}
	else
		return 0.0;
	
	}
	public Customer display(double accno) throws WalletException
	{
		
	c=dataobj.getAccountDetalis(accno);
	return c;
		
	}

	public Customer Deposit(double amount, double accno) throws WalletException{
		Customer obj1=null;
		 obj1=dataobj.getAccountDetalis(accno);
		if(obj1!=null)
		{
			obj1.setBalance(obj1.getBalance()+amount);
			 obj1.setList("amount Deposited from account: "+accno+"is: " +amount+ "total amount is:" +obj1.getBalance());
			dataobj.updateRecord(obj1, accno);
		    obj1= dataobj.getAccountDetalis(accno);
		       
		}
		return obj1;
	}
	@Override
	public Customer Withdraw(double amount, double accno) throws WalletException {
		Customer obj1=new Customer();
		 obj1=dataobj.getAccountDetalis(accno);
		if(obj1!=null)
		{
			if(obj1.getBalance()>=amount)
			{
			obj1.setBalance(obj1.getBalance()-amount);
			 obj1.setList("amount Withdrawn from account: "+accno+"is: " +amount+ "total amount is:" +obj1.getBalance());
			dataobj.updateRecord(obj1, accno);
		    obj1= dataobj.getAccountDetalis(accno);
		   
		                   
		}
				
		}
			
		return obj1;
		

	
	
}
	@Override
	public ArrayList<String> printTransactions(double accno3)
			throws WalletException {
		Customer obj1=new Customer();
		 obj1=dataobj.getAccountDetalis(accno);
		 
		 
		return obj1.getList();
	}
	@Override
	public boolean FundTransfer(double accno1, double accno2, double amount)
			throws WalletException {
		Customer temp1 =new Customer();
		temp1=dataobj.getAccountDetalis(accno1);
		Customer temp2 =new  Customer();
		temp2=dataobj.getAccountDetalis(accno2);
		boolean flag=false;
		
		if(	temp1!=null&&temp2!=null)
		{
		if(temp1.getBalance()>=amount) {
	
		
			temp2.setBalance(temp2.getBalance()+amount);
			temp1.setBalance(temp1.getBalance()-amount);
			temp1.setList(" Amount Transfered :"+amount+" To Acc No: "+temp2.getBalance()+" Total Balance :"+temp1.getBalance());
			temp2.setList(" Depsoited Amount :"+amount+" From Acc No: "+temp1.getAccno()+" Total Balance :"+temp2.getBalance());
			dataobj.updateRecord(temp1,accno1);
			dataobj.updateRecord(temp2,accno2);
			flag=true;
		
		}
		
	}
		else if(temp1.getBalance()<amount)
		{
			System.out.println("Sender Low Balance to transfer");
		flag=false;
		}
		
		else
		{
			System.out.println("No such user account");
		flag= false;
		}
		
	return flag;	
	}
	
}
	
	
	
	
	
	


