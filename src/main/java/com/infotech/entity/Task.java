package com.infotech.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Task")//,schema="employeeCombo@mysqlPU")
public class Task {
    
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long taskId;
	
	@Column
	private String description;
	
	@Column
	private String duration;
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public Long getTaskId() {
		return taskId;
	}


	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Task(Long taskId, String description, String duration) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.duration = duration;
	}

	public Task() {
		super();
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", duration=" + duration + "]";
	}
	
}
