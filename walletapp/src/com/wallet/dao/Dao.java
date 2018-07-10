package com.wallet.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.wallet.bean.Customer;
import com.wallet.exception.WalletException;
public class Dao implements Idao  {
	TreeMap<Double, Customer> store=new TreeMap<Double, Customer>();
	//Set s=store.entrySet();
	
	Customer obj1=new Customer();
	@Override
	public boolean Create_acc(double accno,Customer c) {
		obj1.setAccno(accno);
		 store.put(accno, c);
		 return true;
			
		
	}
	
	public Customer getAccountDetalis(double accno) throws WalletException {	
		/*Iterator itr=s.iterator();
		while (itr.hasNext()) {
			Map.Entry me=(Map.Entry)itr.next();
			if(accno==(Double)me.getKey())
			{
				obj1=(Customer)me.getValue();
				
			}
			else
			{
				obj1=null;
			}
		}

		return obj1;*/
	 obj1=store.get(accno);
	 if(obj1==null)
		 throw new WalletException("account id" + accno+" does not exist" );
		return obj1;
		}


	/*@Override
	public Customer deposit(double accno) throws WalletException {
		
		Iterator itr=s.iterator();
		while (itr.hasNext()) {
			Map.Entry me=(Map.Entry)itr.next();
			if(accno==(Double)me.getKey())
			{
				 obj1=(Customer)me.getValue();
				 double amt1=obj1.getBalance()+amount;
				 obj1.setBalance(amt1);
			}
			else
			{
				obj1=null;
			}
		// TODO Auto-generated method stub
    
	}
		 obj1=store.get(accno);
		
		
		 if(obj1==null)
			 throw new WalletException("account id" + accno+" does not exist" );
			return obj1;

}*/
	
	public void updateRecord(Customer c,double accno)
	{
		store.replace(accno, c);
		
	}

	//@Override
	/*public Customer Withdraw(double amount, double accno)
			throws WalletException {
		
		return null;
	}*/
}
