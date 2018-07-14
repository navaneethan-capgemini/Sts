package com.capgemini.paymentwallet.service;

public class PaymentWalletValidation {
	
	public boolean validateAadharNo(String aadharNo)
	{
		if(aadharNo.length()==12 && aadharNo.matches("[0-9]+"))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean validateCustomerName(String custName)
	{
		if(custName.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$")) {
			return true;
		}
		return false;
	}
	
	public boolean validateGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male")
				|| gender.equalsIgnoreCase("FeMale")
				|| gender.equalsIgnoreCase("M")
				|| gender.equalsIgnoreCase("F"))
		{
			return true;
		}
		return false;
	}
	
	
	
	public boolean validateUserName(String uName)
	{
		if(uName.length()>=8)
		{
			return true;
		}
		return false;
	}
	
	
	public boolean validateMobileNo(String custMobileNo)
	{
		if(custMobileNo.length()==10 && custMobileNo.matches("[0-9]+"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean validateCustInitBal(float custInitBal)
	{
		if(custInitBal >=1000)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public boolean validateUserPassword(String uPassword)
	{
		if(uPassword.length()>=5)
		{
			return true;
		}
		return false;
		
	}

}
