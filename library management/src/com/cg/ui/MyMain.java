package com.cg.ui;

import java.util.Scanner;

import com.cg.dto.LibraryDto;
import com.cg.exception.LibraryException;
import com.cg.service.LibraryService;
import com.cg.dao.*;

public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		LibraryDto dto=new LibraryDto();
		LibraryService libraryService=new LibraryService();	
		
		
		
		
		do
		{
			printDetails();			
			System.out.println("Enter the choice");
			choice=scanner.nextInt();
			
			
			
			switch (choice) {
				
				
				case 1:
					try{
						System.out.println("Enter the member ID");
					
				String mid=scanner.next();
				libraryService.validationdetails(mid);
				
				libraryService.displayDetails(mid);		
				
				for(String i:LibraryDao.map.keySet())
				
				{
					System.out.println("Id is "+LibraryDao.map.get(i).getMid());
					System.out.println("Name is "+LibraryDao.map.get(i).getName());
					System.out.println("balance is "+LibraryDao.map.get(i).getBalance());
				}
					}catch(LibraryException libraryException)
					{
						System.out.println(libraryException.getMessage());
					}
					
				break;
			case 2:
				System.out.println("Enter the member id to be updated");
				String id=scanner.next();
				
				System.out.println("Enter the amount to be updated");
				int payment=scanner.nextInt();
				libraryService.amountBalance(id, payment);
				for(String i:LibraryDao.map.keySet())
				{
					System.out.println("Name "+LibraryDao.map.get(i).getName());
					System.out.println("Id is "+LibraryDao.map.get(i));
					System.out.println("balance is "+LibraryDao.map.get(i).getBalance());
				}
				scanner.close();
			default:
				break;
			}
			
		}while(choice!=0);
		}

	public static void printDetails() {
		System.out.println("Enter the option");
		System.out.println("1.Display Details ");
		System.out.println("2.Update balance");
	}

}
