package com.cg.librarymanagementdummy.ui;

import java.util.Scanner;

import com.cg.librarymanagementdummy.dto.Person;
import com.cg.librarymanagementdummy.exception.LibraryManagementException;
import com.cg.librarymanagementdummy.service.ILibraryManagementService;
import com.cg.librarymanagementdummy.service.LibraryManagementServiceImpl;

public class LibraryManagementUser {

	static ILibraryManagementService service = new LibraryManagementServiceImpl();

	public static void main(String[] args) {
		Integer choice = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			menu();
			System.out.println("Enter your choice");
			choice = new Scanner(System.in).nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Members ID:");
				String memberId = scanner.next();
				boolean validationresult = false;
				try {
					validationresult = service.validatedetails(memberId);
				} catch (LibraryManagementException libraryManagementException) {
					System.out.println(libraryManagementException.getMessage());
				}
				if (validationresult) {
					Person person = service.viewMembers(memberId);
					if (person != null) {
						System.out.println("\nMember ID:\t" + person.getMemberId());
						System.out.println("Member Name:\t" + person.getMembername());
						System.out.println("Amount:\t" + person.getAmount() + "\n");

					} else {
						System.out.println("\nMember is Not Found!!!\n");
					}

				}
				break;
			case 2:
				System.out.println("Enter Members ID:");
				String memberid = scanner.next();
				boolean validationresults = false;
				try {
					validationresults = service.validatedetails(memberid);
				} catch (LibraryManagementException libraryManagementException) {
					System.out.println(libraryManagementException.getMessage());
				}
				if (validationresults) {
					Person person = service.viewMembers(memberid);
					if (person != null) {
						System.out.println("Enter Amount:");
						String amount = scanner.next();
						boolean validationAmount = false;
						try {
							validationAmount = service.validateAmount(amount);
						} catch (LibraryManagementException libraryManagementException) {
							System.out.println(libraryManagementException.getMessage());
						}
						if (validationAmount) {
							String successfullMessage = service.addAmount(memberid, amount);
							if (successfullMessage != null) {
								System.out.println("Amount Successfully updated. " + "\n" + "your Current Balance is: "
										+ successfullMessage);
							}
						}
					} else {
						System.out.println("\nMember is Not Found!!!\n");
					}

				}

				break;
			default:
				break;
			}

		} while (choice != 3);

	}

	private static void menu() {
		System.out.println("1. View Member Details");
		System.out.println("2. Pay Amount");
		System.out.println("3. Exit");

	}

}
