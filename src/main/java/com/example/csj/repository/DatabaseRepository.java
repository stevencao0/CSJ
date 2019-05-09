package com.example.csj.repository;

import java.awt.print.Pageable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.csj.employees.EmployeesModel;
import com.example.csj.employees.GroupEmployee;
import com.example.csj.employees.GroupModel;

@Repository
public class DatabaseRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public List<EmployeesModel>  getAllEmployees(Optional<Integer> page){
		List<EmployeesModel> employeeList = new ArrayList<>();
		
		int pagination = page.orElse(1);
		
		int amountRecord = 10;
		int offset = pagination * 10 ;
		
		//employeeList.addAll(jdbcTemplate.query("SELECT * FROM employees",EmployeesModel.class));
		
        String query = "SELECT * FROM employees LIMIT " + amountRecord+" OFFSET "+offset;
        
	
		employeeList= jdbcTemplate.query(query, new BeanPropertyRowMapper<EmployeesModel>(EmployeesModel.class));
	
		
		return employeeList;
	}
	
	public List<EmployeesModel>  getAllEmployeesSearch(String name, Optional<Integer> page){
		
		List<EmployeesModel> employeeList = new ArrayList<>();
		
		int pagination = page.orElse(1);
		
		int amountRecord = 10;
		int offset = pagination * 10 ;
		
		
		
        //String query = "SELECT * FROM employees WHERE CONCAT(emp_no, '', birth_date, '', first_name,'',last_name,'',hire_date) LIKE '% "+name+"%' LIMIT " + amountRecord+" OFFSET "+offset""
       
        String query = "SELECT * FROM employees WHERE CONCAT(emp_no, '', birth_date, '', first_name,'',last_name,'',hire_date) LIKE '%"+name+"%' LIMIT "+amountRecord+" OFFSET "+offset+" ";
        
        
		employeeList= jdbcTemplate.query(query, new BeanPropertyRowMapper<EmployeesModel>(EmployeesModel.class));
	
		
		return employeeList;
	}
	
	public int  addGroup(GroupModel group){
		
		for(int i =0; i <group.getGroup().size();i++)
		{
			jdbcTemplate.update("INSERT INTO groups (groupName, emp_no, first_name, last_name) VALUES (?,?,?,?)", group.getGroupName(),group.getGroup().get(i).getEmp_no(),group.getGroup().get(i).getFirst_name(),group.getGroup().get(i).getLast_name());
		}
		
		return 1;
	}

	

	public List<String> getGroups(){
		
		List<String> groupList = new ArrayList<>();
		
       
        String query = "SELECT DISTINCT groupName FROM groups";
        
        
        
	groupList = jdbcTemplate.queryForList(query, String.class);
	
		
		return groupList;
	}
	

	public List<GroupEmployee>  getGroupEmployees(String groupName){
		List<GroupEmployee> employeeList = new ArrayList<>();
		
		
        String query = "SELECT emp_no, first_name,last_name FROM groups WHERE groupName = '"+groupName+"'";
        
	
		employeeList= jdbcTemplate.query(query, new BeanPropertyRowMapper<GroupEmployee>(GroupEmployee.class));
	
		
		return employeeList;
	}
	
	
	
}
