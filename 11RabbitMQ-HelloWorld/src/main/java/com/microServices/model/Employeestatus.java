package com.microServices.model;

public class Employeestatus {

	Employee employee;
	String status;
	String meassage;
	public Employeestatus() {
		// TODO Auto-generated constructor stub
	}
	public Employeestatus(Employee employee, String status, String meassage) {
		super();
		this.employee = employee;
		this.status = status;
		this.meassage = meassage;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	@Override
	public String toString() {
		return "Employeestatus [employee=" + employee + ", status=" + status + ", meassage=" + meassage + "]";
	}
	

}
