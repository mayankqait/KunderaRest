package com.infotech.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

@Entity
@Table(name="Employee")//,schema="employeeCombo@mysqlPU")//,indexes = { @Index(name="indexOnName",columnList = "name",unique=true) })
@IndexCollection(columns = { @Index(name = "name")})
public class Employee  extends AuditableClass<String> implements Serializable{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long empId;
	
	@Column
	private String name;
	
	@Column
	private String dept;
	
	@Column
	private Long mobile;
	
	@OneToMany(cascade={CascadeType.ALL})
	private Set<Task> taskList=new HashSet<Task>();;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Employee(Long id, String name, String dept, Long mobile, Set<Task> taskList) {
		super();
		this.empId = id;
		this.name = name;
		this.dept = dept;
		this.mobile = mobile;
		this.taskList = taskList;
	}

	public Set<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(Set<Task> taskList) {
		this.taskList = taskList;
	}

	public Employee() {
		super();
	}

	public Employee(Long id, String name, String dept, Long mobile) {
		super();
		this.empId = id;
		this.name = name;
		this.dept = dept;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [id=" + empId + ", name=" + name + ", dept=" + dept + ", mobile=" + mobile + ", taskList="
				+ taskList + "]";
	}

}
