package com.imaginnovate.EmployeeTaxManagement;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee)
	{
		Employee emp = employeeService.saveEmployee(employee);
		if (emp != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(emp);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee details are not saved.");
        }		
	}
	
	@GetMapping("/taxinfo")
	public ResponseEntity<List<EmployeeTaxDto>> getEmployeeTaxDetails()
	{
		List<Employee> employees = employeeService.getAllEmployees();
        
        List<EmployeeTaxDto> employeeTaxList = employees.stream()
            .map(employee -> employeeService.calculateTax(employee))
            .collect(Collectors.toList());

        // Return the tax info as a response
        return ResponseEntity.ok(employeeTaxList);
	}

}
