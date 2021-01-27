package com.techlineafrica.interfaces;

import com.techlineafrica.model.Employee;

import java.util.List;

public interface EmployeeInterface {
	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
