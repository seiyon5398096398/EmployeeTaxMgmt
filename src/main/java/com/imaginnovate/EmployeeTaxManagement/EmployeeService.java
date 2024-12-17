package com.imaginnovate.EmployeeTaxManagement;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(@Valid Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	public EmployeeTaxDto calculateTax(Employee employee) {
		
        double tax = 0.0;
        double yearlySalary = calculateYearlySalary(employee);
        
        
        if(yearlySalary <= 250000) {
            tax = 0;
        } else if(yearlySalary>250000 && yearlySalary <= 500000) {
            tax = (yearlySalary - 250000) * 0.05;
        } else if(yearlySalary>500000 && yearlySalary <= 1000000) {
            tax = (250000 * 0.05) + (yearlySalary - 500000) * 0.10;
        } else {
            tax = (250000 * 0.05) + (500000 * 0.10) + (yearlySalary - 1000000) * 0.20;
        }

        double additionalcess = 0;
        if (yearlySalary > 2500000) {
            additionalcess = (yearlySalary - 2500000) * 0.02 ;
        }

        double cess = tax * 0.04;
        double totalTax = tax + cess + additionalcess;

        return new EmployeeTaxDto(
            employee.getEid(),
            employee.getFirstname(),
            employee.getLastname(),
            (long) yearlySalary,
            totalTax,
            cess
        );
    }

    private double calculateYearlySalary(Employee employee) {
    	
        LocalDate doj = employee.getDoj().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        
        long months = ChronoUnit.MONTHS.between(doj, LocalDate.of(doj.getYear() + 1, Month.MARCH, 31)) + 1;

        double monthlySalary = employee.getSalary();

        if (doj.getDayOfMonth() > 1) {
            int daysInMonth = doj.lengthOfMonth();   
            double dailySalary = monthlySalary / daysInMonth;  

            monthlySalary -= dailySalary * (doj.getDayOfMonth() - 1);  
        }

        return monthlySalary * months;
    }

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}

