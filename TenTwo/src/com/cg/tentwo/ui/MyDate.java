package com.cg.tentwo.ui;

public class MyDate {
	int intDay,intMonth,intYear;
	// Constructor
	public MyDate(){
		
	}
	public MyDate(int intDay, int intMonth, int intYear) {
		this.intDay = intDay;
		this.intMonth = intMonth;
		this.intYear = intYear;
	}

	// setter and getter methods
public void setDay(int intDay)	
{
	this.intDay = intDay;
}

	public int getDay( )		
{
	return  this.intDay;
}

public void setMonth(int intMonth)
{
	this.intMonth = intMonth;
}

public int getMonth( )
{
	return  this.intMonth;
}

public void setYear(int intYear)
{
	this.intYear=intYear;
}

public int getYear( )
{
	return  this.intYear;
}

public String toString() //converts date obj to string.    
{
	String str = "Date is " +intDay + "/" +intMonth + "/" +intYear;
	return	str; 
}

}
