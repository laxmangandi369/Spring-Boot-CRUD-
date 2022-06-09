package com.springbootcrud.SpringBootCRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.SpringBootCRUD.beans.EmployeeBean;
import com.springbootcrud.SpringBootCRUD.services.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServices empservice;

	@GetMapping("/getAllEmployee")
	public List<EmployeeBean> getAllEmployee() {
		return empservice.getAllEmployee();
	}

	@PostMapping(value="/addEmployee")
	public EmployeeBean addEmployee(@RequestBody EmployeeBean employee) {
		return empservice.saveEmployee(employee);
	}

	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody EmployeeBean employee) {
		empservice.saveEmployee(employee);
	}

	@GetMapping(value = "/getEmployee/{id}")
	public Optional<EmployeeBean> getEmployeeById(@PathVariable("id") Integer id) {
		return empservice.findEmployee(id);
	}

	@DeleteMapping(value = "/deleteEmployee/{id}")
	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		System.out.println("Id from user" + id);
		
		empservice.deleteEmployee(id);
	}

	@PutMapping(value = "/updateEmployee")
	public void updateEmployeeById(@RequestBody EmployeeBean employee) {
		empservice.updateEmployee(employee);
	}

}
