package com.wallet.bean;

import java.lang.reflect.Array;
import java.util.ArrayList;



	public class Customer {
		private String cname;
		//private int acnt_num;
		private String mob_num;
		//private String address;
		private double balance=0.00;
		private String pwd;
		private double accno;
		ArrayList<String> list=new ArrayList<String>();
		
		
		public ArrayList<String> getList() {
			return list;
		}

		public void setList(String string) {
			list.add(string);
		}

		public double getAccno() {
			return accno;
		}

		public void setAccno(double accno) {
			this.accno = accno;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

	

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public String getMob_num() {
			return mob_num;
		}

		public void setMob_num(String mob_num) {
			this.mob_num = mob_num;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		} 
	}



