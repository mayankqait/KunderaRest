package com.infotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infotech.entity.Employee;

@Repository
public interface EmpRepository  extends JpaRepository<Employee,Integer>{
     
	@Query(value="SELECT e FROM Employee e WHERE e.name = :name")
	public List<Employee> findByName(@Param("name") String name);
	
	/*@Query(value="SELECT * FROM employee  WHERE id = :id") 
    public Employee findOne(@Param(value = "id") int id);*/
	
	@Query(value="DELETE FROM Employee e WHERE e.id = :id",nativeQuery=true) 
	 public void delete(@Param(value = "id") Long id);
}
