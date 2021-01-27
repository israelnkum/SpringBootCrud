package com.techlineafrica.controller;

import com.techlineafrica.model.Employee;
import com.techlineafrica.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	//home page route
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/add/employee")
	public String newEmployeeForm(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		
		return "addEmployee";
	}
	
	@PostMapping("/add/employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		
		//save employee
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/update/employee/{id}")
	public String updateEmployee(@PathVariable long id, Model model){
		//get employee from service
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as a model attribute to prepopulate the form
		
		model.addAttribute("employee", employee);
		
		return "updateEmployee";
	}
	
	@GetMapping("/delete/employee/{id}")
	public String deleteEmployee(@PathVariable long id){
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
