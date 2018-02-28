package com.infotech.service;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.entity.Employee;
import com.infotech.entity.Task;
//import com.infotech.repository.EmpRepository;
import com.infotech.repository.EmpRepository;

@Transactional
@Service
public class EmployeeServiceimpl implements EmployeeService  {
	
	@Autowired
	EntityManagerBean em;
	
	@Autowired 
	private EmpRepository employeeRepository;
	
	public List<Employee> findByName(String name){
		Query q = em.getEntityManagerBean().createQuery("Select e from Employee e where e.name = :name");
		q.setParameter("name", name);
		List<Employee> e=(List<Employee>) q.getResultList();
		System.out.println("####### = "+q.getResultList());
		//return employeeRepository.findByName(name);
		return e;
	}
	
	@Transactional
	@Override
	public Employee findOne(int id) {
		return	em.getEntityManagerBean().find(Employee.class, id);
		//return employeeRepository.findOne(id);
	}

	/*@Override
	public List<Employee> findAll() {
		
		return (List<Employee>) employeeRepository.findAll();
	}*/
	@Transactional
	 public String save  (Employee e) {
		em.getEntityManagerBean().persist(e);
		em.getEntityManagerBean().getTransaction().begin();
		System.out.println("****************************8 "+em.getEntityManagerBean().getDelegate()+em.getEntityManagerBean().isJoinedToTransaction());
		return "Entity saved";
		//return employeeRepository.save(e);
	 }
	 
	 public String saveTask(Task t) {
		 em.getEntityManagerBean().persist(t);
		 return "Task saved.";
	 }
	
	 public void deleteById(Long id) {
		 
		 employeeRepository.delete(id);
	 }

}
