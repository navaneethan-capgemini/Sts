package com.capgemini.paymentwallet.bean;

import java.time.LocalDate;

public class Wallet {

	private float custBal;
	private int custAccNo;
	private LocalDate custAccDate;
	private Customer customerDetails;

	public float getCustBal() {
		return custBal;
	}

	public void setCustBal(float custBal) {
		this.custBal = custBal;
	}

	public int getCustAccNo() {
		return custAccNo;
	}

	public void setCustAccNo(int custAccNo) {
		this.custAccNo = custAccNo;
	}

	public LocalDate getCustAccDate() {
		return custAccDate;
	}

	public void setCustAccDate(LocalDate custAccDate) {
		this.custAccDate = custAccDate;
	}

	public Customer getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		return "Wallet [custBal=" + custBal + ", custAccNo=" + custAccNo + ", custAccDate=" + custAccDate
				+ ", customerDetails=" + customerDetails + "]";
	}

}
