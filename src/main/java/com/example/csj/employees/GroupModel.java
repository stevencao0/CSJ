package com.example.csj.employees;

import java.util.List;
import java.util.ArrayList;

public class GroupModel {

	private String groupName;
	private List <EmployeesModel> group;
	
	public GroupModel(String groupName, List<EmployeesModel> group) {
		super();
		this.groupName = groupName;
		this.group = group;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	public GroupModel() {
		super();
	}
	

	public List<EmployeesModel> getGroup() {
		return group;
	}
	public void setGroup(List<EmployeesModel> group) {
		this.group = group;
	}
	
	
}
