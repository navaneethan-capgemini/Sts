package com.cg.librarymanagementdummy.dto;

public class Person {

	private String memberId;
	private String memberName;
	private String amount;

	public Person() {

	}

	public Person(String memberId, String membername, String amount) {
		super();
		this.memberId = memberId;
		this.memberName = membername;
		this.amount = amount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMembername() {
		return memberName;
	}

	public void setMembername(String membername) {
		this.memberName = membername;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
