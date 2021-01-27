package com.techlineafrica.service;

import com.techlineafrica.interfaces.EmployeeInterface;
import com.techlineafrica.model.Employee;
import com.techlineafrica.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeInterface {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		Employee employee = null;
		if (optionalEmployee.isPresent()){
			employee = optionalEmployee.get();
		}else {
			throw new RuntimeException("Employee not found");
		}
		
		return  employee;
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}
}
