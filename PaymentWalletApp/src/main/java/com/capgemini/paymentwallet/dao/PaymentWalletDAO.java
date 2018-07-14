package com.capgemini.paymentwallet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.paymentwallet.bean.Wallet;

public class PaymentWalletDAO implements IPaymentWalletDAO {

	static HashMap<String, Wallet> map = new HashMap<>();
	static Wallet account;
	static List<String> transaction=new ArrayList<String>();

	int tId=(int) ((Math.random()*123)+999);	
	
	
	public boolean addWalletDetails(Wallet wallet) {

		for (String key : map.keySet()) {
			if (wallet.getCustomerDetails().getuName().equals(key)) // UserName already exist
			{
				return false;
			}
		}

		map.put(wallet.getCustomerDetails().getuName(), wallet); // New Account added to Collection
		return true;
	}
	
	
	

	public boolean loginAccount(String uName, String uPassword) {

		for (String key : map.keySet()) {
			account = map.get(key);
			if (account.getCustomerDetails().getuName().equals(uName)
					&& account.getCustomerDetails().getuPassword().equals(uPassword)) {
				return true;
			}
		}
		return false;

	}
	
	
	

	public float showBalance() {

		return account.getCustBal(); 				// return account balance
	}
	
	
	

	public boolean depositAmount(float amount) {

		account.setCustBal(account.getCustBal() + amount); // Depositing Amount
		String deposit = tId +"  Amount of "+amount+" is deposited:      "+account.getCustBal();
		transaction.add(deposit);
		return true;
	}
	
	
	

	@Override
	public boolean withdrawAmount(float amount) {

		if (account.getCustBal() >= (amount + 1000)) // Minimum Balance Check
		{
			account.setCustBal(account.getCustBal() - amount); // if true then withdraw.
			
			String with=tId +"  Amount of "+amount+" is withdrawn      "+account.getCustBal();
			transaction.add(with);
			return true;
		}
		else {
			System.out.println("Minimum Balance Violation");
		}
		return false;

	}
	
	
	

	@Override
	public boolean fundTransfer(int accNo, float amount) {

		if (account.getCustBal() < (amount + 1000)) {
			System.out.println("Minimum Balance Violation");
			return false;
		}

		for (String key : map.keySet()) {
			Wallet recvAccount = map.get(key);
			if (recvAccount.getCustAccNo() == accNo) {

				recvAccount.setCustBal(recvAccount.getCustBal() + amount);
				account.setCustBal(account.getCustBal() - amount);
				
				String transfer = tId +"  Amount of "+ amount +
						" is withdrawn from "+account.getCustAccNo() +
						"and deposited in"+recvAccount.getCustAccNo();
						
				transaction.add(transfer);
				return true;

			}

		}

		System.out.println("Incorrect Reciever Account Number"); // Fails to match account number

		return false;
	}




	@Override
	public List<String> printTransaction() {
		
		return transaction;
	}
	
	
	
	

	
	

}
