package com.wallet.pl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.wallet.bean.Customer;
import com.wallet.dao.Dao;
import com.wallet.exception.WalletException;
import com.wallet.service.Service;
public class Presentation  {
public static void main(String[] args) throws Exception {
	Service c2=new Service();

	Dao d1=new Dao();
	System.out.println("*****welcome to BankWallet****");
	
	Scanner sc=new Scanner(System.in);
	

	int i,u = 0;
	boolean flag1;
	do{
		System.out.println("***Menu***");
		System.out.println("1.Create Account");
		System.out.println("2. Display");
		System.out.println("3.Deposit");
		System.out.println("4. Withdraw");
        System.out.println("5. Print Transactions");
        System.out.println(" 6. Fund Transfer");
		System.out.println("select option:");
		i=sc.nextInt();
		switch (i) {
		case 1:
			Customer c=new Customer();
			flag1=true;
			System.out.println("enter name:");
		    
		    while(flag1){
		    	String name=sc.next();
				  boolean flag=c2.validateName(name);
			if(flag){
				c.setCname(name);
				break;
			}
			else{
				System.out.println("enter valid name:");
				flag1=true;
			}
		    }
System.out.println("enter num :");
		    
		    while(flag1){
		    	String num=sc.next();
				  boolean flag=c2.validateNumber(num);
			if(flag){
				c.setMob_num(num);
				break;
			}
			else{
				System.out.println("enter valid number:");
				flag1=true;
			}
		    }
System.out.println("enter password:");
		    
		    while(flag1){
		    	String pwd=sc.next();
				  boolean flag=c2.validatePwd(pwd);
			if(flag){
				c.setPwd(pwd);
				break;
			}
			else{
				System.out.println("enter valid password:");
				flag1=true;
			}
		    }
		    double accno=c2.createAcc(c);
		    if(accno!=0.0)
		    	System.out.println("succesfully created and your account num is:" +accno) ;
		    	
			break;
		case 2:
			try{
			System.out.println("enter accno");
			double accno1=sc.nextDouble();
			c=c2.display(accno1);

			if(c != null)
			{
			System.out.println("name:"+c.getCname());
			System.out.println("number:"+c.getMob_num());
			System.out.println("balance:"+c.getBalance());

			}
			
			
			break;
			}catch(WalletException  we){
				
				System.out.println(we.getMessage());
				continue;
			}
		
		case 3:
			try{System.out.println("enter accno");
		double accno2=sc.nextDouble();
		System.out.println("enter the amount to be deposited");
		double amount=sc.nextDouble();
		Customer obj1=c2.Deposit(amount, accno2);
		System.out.println("total amount:"+obj1.getBalance());
		
			break;
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				continue;
			}
		case 4:try
		{
			System.out.println("enter acc no:");
			double accno3=sc.nextDouble();
			System.out.println("enter the amount to be withdraw: ");
			double amount=sc.nextDouble();
			Customer obj=c2.display(accno3);
			double balance=obj.getBalance();
			Customer obj1=c2.Withdraw(amount, accno3);
			if(balance!=obj1.getBalance())
			System.out.println("total amount after withdraw:" +obj1.getBalance());
			else
			{
				System.out.println("yo do not have sufficient amount ");
				System.out.println("Amount in your account=" +obj.getBalance());
			}	
			break;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			continue;
		}
		case 5:
			try{
				System.out.println("enter acc no:");
				double accno3=sc.nextDouble();
				ArrayList<String> list=c2.printTransactions(accno3);
				Iterator itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				continue;
			}
		case 6:
			try
			{
				System.out.println("enter from account number:");
				double accno4=sc.nextDouble();
				System.out.println("enter to account number:");
				double accno5=sc.nextDouble();
				System.out.println("enter the amount to be transfered:");
				double amount=sc.nextDouble();
				boolean flag=c2.FundTransfer(accno4, accno5, amount);
				if(flag)
				{
					System.out.println("fund transfer successful");
				}
				else
					System.out.println("fund transfer not successful");
				
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				continue;
			}
		default:
			break;
		}
		System.out.println("to continue press 1");
		u=sc.nextInt();
	}while(u==1);
}

}
