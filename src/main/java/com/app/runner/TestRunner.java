package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.app.dto.EmployeeDTO;
import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Component
public class TestRunner implements ApplicationRunner{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("From run method in TestRunner class.");
		
		System.out.println("---- To get record by getAllEmployees() method ----");
		List<EmployeeDTO> employeeList1 = employeeRepository.getAllEmployees();
		employeeList1.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("---- To get record by getEmployeesByDesignation(String designation) method ----");
		List<EmployeeDTO> employeeList2 = employeeRepository.getEmployeesByDesignation("QA Engineer");
		employeeList2.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
	}

}
