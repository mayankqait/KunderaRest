package com.infotech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infotech.entity.Employee;
import com.infotech.entity.Task;


public interface EmployeeService {

	public List<Employee> findByName(String name);
	 public Employee findOne(int id);
	// public List<Employee> findAll();
	 public String save(Employee e);
	 public String saveTask(Task t);
	 public void deleteById(Long id);
}
