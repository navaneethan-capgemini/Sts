package com.wallet.dao;
import com.wallet.bean.Customer;
import com.wallet.exception.WalletException;
public interface Idao {
	public boolean Create_acc(double accno,Customer c);
	public Customer getAccountDetalis(double accno)throws WalletException;
	//public Customer deposit(double accno) throws WalletException;
	//public Customer Withdraw(double amount, double accno) throws WalletException;
	
	
	

}
