package com.example.csj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.example.csj.employees.EmployeesModel;
import com.example.csj.employees.GroupEmployee;
import com.example.csj.employees.GroupModel;
import com.example.csj.repository.DatabaseRepository;

// @RequestMapping (value = "/url", method = RequestMethod.GET)
// public string hello(HttpServletRequest request)
//String name = request.getParameter("name");
//return "<h1>" + HelloMessage.getMessage(name)+"<h1>";

@Controller
public class DatabaseController {
	
	
	@Autowired
	DatabaseRepository dbRepository;
	
	
	
	
	@RequestMapping(path="/home", method = RequestMethod.GET)
	public ModelAndView getAllEmployees(@RequestParam Optional<Integer> page){
		
		ModelAndView view = new ModelAndView("home");
		
		List<EmployeesModel> dbEmployee = dbRepository.getAllEmployees(page);
		

		//	System.out.println("tEST "+dbEmployee.get(0).getFirst_name());
		
			view.addObject("employeeList",dbEmployee);
		
		return view;
	}
	
	@RequestMapping(path="/home", method = RequestMethod.POST)
	public ModelAndView getAllEmployeesSearch(HttpServletRequest request, @RequestParam Optional<Integer> page){
		
		ModelAndView view = new ModelAndView("home");
		
		String name = request.getParameter("name");
		
		List<EmployeesModel> dbEmployee = dbRepository.getAllEmployeesSearch(name,page);
		
		
			view.addObject("employeeList",dbEmployee);
		
		return view;
	}
	

	@RequestMapping( value="/group",  method = RequestMethod.POST)
	
	public String getGroups( @RequestBody GroupModel group){
		
		
	//	System.out.println("test: "+group.get(0).getFirst_name());
		
		for(int i =0; i < group.getGroup().size(); i++)
		{
			System.out.println("test: "+group.getGroup().get(i).getFirst_name());
		}
		
		System.out.println("GroupName: "+group.getGroupName());
		
		
		int x = dbRepository.addGroup(group);
	
		
		String test = "t";
		
		return test;
	}
	
	
	@RequestMapping(path="/getGroups", method = RequestMethod.GET)
	public ModelAndView getGroupsList( ){
		
		
		ModelAndView view = new ModelAndView("groups");
				
		List<String> groupList = dbRepository.getGroups();
		
		
			view.addObject("groupList",groupList);
		
		return view;

	}
	
	
	@RequestMapping(path="/group", method = RequestMethod.GET)
	public ModelAndView getAllEmployees(@RequestParam String groupName){
		
		ModelAndView view = new ModelAndView("group");
		
		
		List<GroupEmployee> dbEmployee = dbRepository.getGroupEmployees(groupName);
		
		
		view.addObject("employeeList",dbEmployee);
		
		return view;
	}
	
	
}
