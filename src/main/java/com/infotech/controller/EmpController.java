package com.infotech.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.entity.Employee;
import com.infotech.entity.Task;
//import com.infotech.repository.EmpRepository;
import com.infotech.service.EmployeeService;


@RestController
@RequestMapping(value="/todo")
public class EmpController  {
 
    @Autowired
    private EmployeeService employeeService;
    
   
   /* @GetMapping(path="/all")
    public List<Employee> getAllEmployee(){
    	return (List<Employee>) employeeService.findAll();
    }*/
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") int id)throws IllegalArgumentException {
    	return employeeService.findOne(id);
    }
    
    
    
    @PostMapping(path="/add")
    public ResponseEntity addEmployee(@RequestBody Employee e){
    	employeeService.save(e);
		return new ResponseEntity(e, HttpStatus.OK);
    }
    
    @PostMapping(path="/addTask")
    public ResponseEntity addEmployee(@RequestBody Task t){
    	employeeService.saveTask(t);
		return new ResponseEntity(t, HttpStatus.OK);
    }
    
    @PutMapping(path="/update/{id}")
	public String update(@RequestBody Employee e,@PathVariable("id") Integer id) {
		Employee oldData=(Employee)employeeService.findOne(id);
		if(oldData!=null) {
			oldData.setName(e.getName());
			oldData.setDept(e.getDept());
			oldData.setMobile(e.getMobile());
			oldData.setTaskList(e.getTaskList());
			employeeService.save(e);
			return oldData.toString();
		}
		else {
			return "User does not esist.";
		}
	}
     
    @DeleteMapping(path="/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
    	employeeService.deleteById(id);
    	return "Employee with id = "+id+" is deleted.";
    }
    
    @GetMapping(path="/getByName/{name}")
    public List<Employee> getByName(@PathVariable("name") String name) {
    	return employeeService.findByName(name);
    }
    
    /*@GetMapping(path="/getTaskOfEmployeeById/{id}")
	public Set<String> getTaskOfEmployeeByName(@PathVariable("id") int id) {
		Employee e=employeeService.findOne(id);
		return e.getTaskList();
	}*/
    
}