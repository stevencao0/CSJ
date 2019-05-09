package com.example.csj.employees;

public class GroupEmployee {

	private String groupName;
	private int emp_no;
	private String first_name;
	private String last_name;
	
	
	
	public GroupEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupEmployee(String groupName, int emp_no, String first_name, String last_name) {
		super();
		this.groupName = groupName;
		this.emp_no = emp_no;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
