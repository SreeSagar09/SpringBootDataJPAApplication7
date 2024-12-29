package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.dto.EmployeeDTO;
import com.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select new com.app.dto.EmployeeDTO(e.employeeId, e.employeeCode, e.employeeName, e.age, e.designation) from Employee e")
	public List<EmployeeDTO> getAllEmployees();
	
	@Query("select new com.app.dto.EmployeeDTO(e.employeeId, e.employeeCode, e.employeeName) from Employee e where e.designation =?1")
	public List<EmployeeDTO> getEmployeesByDesignation(String designation);
}
