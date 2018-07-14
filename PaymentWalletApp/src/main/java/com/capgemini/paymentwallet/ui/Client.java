package com.capgemini.paymentwallet.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;
import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;
import com.capgemini.paymentwallet.service.PaymentWalletService;
import com.capgemini.paymentwallet.service.PaymentWalletValidation;


public class Client {

	public static void main(String[] args) {
		
		
		int choice = 0;
		do {
			int choice1=0;
			Scanner scan = new Scanner(System.in);
			System.out.println("\t\t\t\t_____________________________________________________");
			System.out.println("\t\t\t\t............PAYMENT WALLET APPLICATION...............");
			System.out.println("\t\t\t\t_____________________________________________________");
			System.out.println("\t\t\t\t..                                                 ..");
			System.out.println("\t\t\t\t..            	  1.SignUp                         ..");
			System.out.println("\t\t\t\t..          	  2.Login                          ..");
			System.out.println("\t\t\t\t..                3.Exit                           ..");
			System.out.println("\t\t\t\t..                                                 ..");
			System.out.println("\t\t\t\t.....................................................");
			System.out.println("\t\t\t\t.....................................................");
			System.out.println("\t\t\t\t...............Enter Your Choice.....................");
			
				
					choice= scan.nextInt();
				
				
			
			
			switch(choice)
			{
			case 1:
				createAccount();
				break;
				
			case 2:
				
				boolean b= loginAccount();
				if(b)
				{
					do {
						
						System.out.println("________________________");
						System.out.println("..........Menu..........\n");
						System.out.println("1. SHOW BALANCE\t\t\t\t 4. FUND TRANSFER");
						System.out.println("2. DEPOSIT AMOUNT\t\t\t 5. PRINT TRANSACTION");
						System.out.println("3. WITHDRAW AMOUNT \t\t\t 6. SIGN OUT");
						
						System.out.println("\nHello User......\nEnter Your Choice");
						
						choice1= scan.nextInt();
						
						switch(choice1)
						{
						
						case 1 : 
							showBalance();
							break;
							
						case 2:
							depositAmount();
							break;
							
						case 3 : 
							withdrawAmount();
							break;
							
						case 4:
							fundTransfer();
							break;
							
						case 5:
							printTransaction();
							break;
							
						
						
						
						}
					
					}while(choice1!=6);
					
					
				}
				
				else
				{
					System.out.println("Invalid Login Details..Try Again..");
				}
			break;
			
			default :
				System.out.println("Invalid Choice..Please Try Again..");
				break;
			
			}
		}while(choice!=3);
		
		
			
		
		
	}
	
	
	public static void createAccount()
	{
		
		
		Wallet wallet = new Wallet();
		Customer account = new Customer();
		
		
		PaymentWalletService service = new PaymentWalletService();
		PaymentWalletValidation validate = new PaymentWalletValidation();
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your UserName ");
		String uName = scan.nextLine();
		boolean isValidUserName = validate.validateUserName(uName);
		
		
		System.out.println("Enter your Password");
		String uPassword = scan.nextLine();
		boolean isValidPassword = validate.validateUserPassword(uPassword);
		
		System.out.println("Enter Customer Name");
		String custName = scan.nextLine();
		boolean isValidCustName = validate.validateCustomerName(custName);
		
		System.out.println("Enter Customer 12 digit Aadhar Number");
		String aadharNo = scan.nextLine();
		boolean isValidAadharNo = validate.validateAadharNo(aadharNo);
		
		
		
		System.out.println("Enter Customer Age");
		int age = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Enter Customer gender");
		String gender = scan.nextLine();
		boolean isValidGender = validate.validateGender(gender);
		
		
		System.out.println("Enter Customer Mobile Number");
		String custMobileNo = scan.nextLine();
		boolean isValidMobileNo = validate.validateMobileNo(custMobileNo);
		
		
		System.out.println("Enter Customer Address");
		String custAddress = scan.nextLine();
		
		
		
		System.out.println("Enter Customer EmailID");
		String custEmail = scan.nextLine();
		
		
		System.out.println("Enter Opening Blanace");
		float custInitBal = scan.nextFloat();
		boolean isValidCustInitBal = validate.validateCustInitBal(custInitBal);
		
		
		int custAccNo = (int)(Math.random() * 123456+123456);
		LocalDate custAccOpenDate = LocalDate.now();
		
		
		
		
	
		
		if(isValidAadharNo &&  isValidMobileNo &&  isValidCustInitBal
				&& isValidUserName && isValidPassword && isValidCustName 
				&& isValidGender)
		{
			
			account.setuName(uName);
			account.setuPassword(uPassword);
			account.setAadharNo(aadharNo);
			account.setCustName(custName);
			account.setAge(age);
			account.setGender(gender);
			account.setCustAddress(custAddress);
			account.setCustEmail(custEmail);
			account.setCustMobileNo(custMobileNo);
			
			wallet.setCustAccDate(custAccOpenDate);
			wallet.setCustAccNo(custAccNo);
			wallet.setCustBal(custInitBal);
			wallet.setCustomerDetails(account);
			
			
			
		
			boolean b = service.addWalletDetails(wallet);
			if(b)
			{
				
				System.out.println("Account Created.. Account Number is: "+custAccNo);
				System.out.println("Your UserName is: "+uName);
				System.out.println("Your Password is :"+uPassword);
				
			}else
			{
				System.out.println("Account Not Created");
			}
			
			
			
		
			
			
		}
		
		else
		{
			
			if(!isValidUserName)
			{
				System.out.println("Invalid UserName \n UserName cannot be less than 8 character");
				
			}
			if(!isValidPassword)
			{
				System.out.println("Invalid Password\n Password cannot be less than 5 character");
			}
			if(!isValidAadharNo)
			{
				System.out.println("Invalid Aadhar No \n Aadhar no should be equal to 12 digits and contains only numbers");
			}
			if(!isValidCustName)
			{
				System.out.println("Customer Name Can contain only Letters");
			}
			
			if(!isValidGender)
			{
				System.out.println("Invalid Gender");
			}
			
			if(!isValidMobileNo)
			{
				System.out.println("Invalid Mobile Nuber \n Mobile No should be 10 character long and can contain only numbers");
			}
			if(!isValidCustInitBal)
			{
				System.out.println("Invalid Initial Balance\n Balance should be greater than 500");
			}
			
		}
		
		
	}
	
	
	public static void showBalance()
	{
		Scanner scan = new Scanner(System.in);
		
		PaymentWalletService service = new PaymentWalletService();
		
		float balance = service.showBalance();
			System.out.println("Account Balance is: "+balance);
	}
	
	public static void depositAmount()
	{
		Scanner scan = new Scanner(System.in);
		PaymentWalletService service = new PaymentWalletService();
		
		System.out.println("Enter amount to deposit");
		float amount = scan.nextFloat();
		boolean isDeposit = service.depositAmount(amount);
		
		if(isDeposit)
		{
			System.out.println("Amount Deposited in your account");
		}
		
		
	}
	
	public static void withdrawAmount()
	{
		Scanner scan = new Scanner(System.in);
		PaymentWalletService service = new PaymentWalletService();
		
		System.out.println("Enter amount to withdraw");
		float amount = scan.nextFloat();
		boolean isDeposit = service.withdrawAmount(amount);
		
		if(isDeposit)
		{
			System.out.println("Amount Withdraw from your account");
		}
		
		
		
	}
	
	public static boolean loginAccount()
	{
		Scanner scan = new Scanner(System.in);
		PaymentWalletService service = new PaymentWalletService();
		System.out.println("Enter Your Username");
		String uName = scan.nextLine();
		System.out.println("Enter Your Password");
		String uPassword = scan.nextLine();
		
		boolean b= service.loginAccount(uName, uPassword);
		if(b)
		{
			return true;
		}
		
		return false;
	}
	
	public static void fundTransfer()
	{
		Scanner s = new Scanner(System.in);
		System.out.println(" Enter Account Number to transfer amount");
		int accNo = s.nextInt();
		System.out.println("Enter Amount to Transfer");
		float amount = s.nextFloat();
		PaymentWalletService service = new PaymentWalletService();
		boolean b= service.fundTransfer(accNo,amount);
		if(b)
		{
			System.out.println("Fund Successfully Transfer");
		}
		else
		{
			System.out.println("Enter Correct Input");
		}
		
	}
	public static void printTransaction()
	{
		
		PaymentWalletService service = new PaymentWalletService();;
		
		List<String> l1=service.printTransaction();
			
		Iterator<String> it=l1.iterator();
			while(it.hasNext()) {
			String s= it.next();
			System.out.println(s);
			}
	}

}
