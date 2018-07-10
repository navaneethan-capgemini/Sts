package com.wallet.exception;

public class WalletException extends Exception {
	
String message;
	
	public  WalletException(String msg)
	{
		message=msg;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
