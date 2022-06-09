package com.springbootcrud.SpringBootCRUD.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.SpringBootCRUD.beans.EmployeeBean;
import com.springbootcrud.SpringBootCRUD.dao.EmployeeDAO;

@Service
@Transactional
public class EmployeeServices {
	@Autowired(required= true)
	private EmployeeDAO empdao;
	
	public List<EmployeeBean> getAllEmployee()
	{
		return (List<EmployeeBean>)empdao.findAll();
	}
	public EmployeeBean saveEmployee(EmployeeBean employee) {
		return empdao.save(employee);
	}
	
	public Optional<EmployeeBean> findEmployee(Integer id) {
		return empdao.findById(id);
	}
	
	public void updateEmployee(EmployeeBean employee) {
		EmployeeBean existingEmployee = empdao.findById(employee.getId()).orElse(null);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setSalary(employee.getSalary());
		empdao.save(existingEmployee);
	}
	
	public String deleteEmployee(Integer id) {
		empdao.deleteById(id);
		return "employee removed"+id;
	}
}
