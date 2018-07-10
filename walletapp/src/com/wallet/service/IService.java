package com.wallet.service;

import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import com.wallet.bean.Customer;
import com.wallet.exception.WalletException;

public interface IService {
public boolean validateName(String s) throws WalletException;
public boolean validateNumber(String n)throws WalletException;
public boolean validatePwd(String pwd)throws WalletException;	
public Customer display(double accno) throws WalletException ;
public double createAcc(Customer c);
public Customer Deposit(double amount, double accno) throws WalletException;
public Customer Withdraw(double amount, double accno) throws WalletException;
public ArrayList<String> printTransactions(double accountNo) throws WalletException;
public boolean FundTransfer(double accno1,double accno2, double amount)throws WalletException;
}
