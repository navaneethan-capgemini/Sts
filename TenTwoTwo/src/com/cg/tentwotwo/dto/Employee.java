package com.cg.tentwotwo.dto;

import com.cg.tentwotwo.exception.EmployeeException;

public class Employee {
	private int empId;
	private String empName;
	private double empSalary;
	private String designation;
	private String insuranceScheme;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) throws EmployeeException {
		if (empSalary < 3000) {
			throw new EmployeeException("Salary cannot be less than 3000");
		}

		else {

			if ((empSalary > 5000 && empSalary < 20000)) {
				setInsuranceScheme("Scheme C");
				setDesignation("System Associate");
			}

			else if ((empSalary >= 20000 && empSalary < 40000)) {
				setInsuranceScheme("Scheme B");
				setDesignation("Programmer");
			}

			else if ((empSalary >= 40000)) {
				setInsuranceScheme("Scheme A");
				setDesignation("Manager");
			}

			else {
				setInsuranceScheme("No Scheme");
				setDesignation("Clerk");
			}
			this.empSalary = empSalary;
		}
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getInsuranceScheme() {
		return insuranceScheme;
	}

	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}

}

