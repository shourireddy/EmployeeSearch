package com.employee.search;

public class Employee {

	private String Fname;
	private String address;
	private String Lname;
	private String phone;
	private String work;
	private String home;

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public Employee(String fname, String address, String lname) {
		super();
		Fname = fname;
		this.address = address;
		Lname = lname;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
