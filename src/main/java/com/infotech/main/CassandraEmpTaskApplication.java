package com.infotech.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.infotech.entity")
//@EnableCassandraRepositories("com.infotech.repository")
@EnableJpaRepositories(basePackages= {"com.infotech.repository"})
@ComponentScan(basePackages="com.infotech")
public class CassandraEmpTaskApplication {

	public static void main(String[] args) {
		
	    /*EntityManagerFactory emf =Persistence.createEntityManagerFactory("cassandra_pu,mysqlPU");
	    EntityManager em = emf.createEntityManager();*/
		SpringApplication.run(CassandraEmpTaskApplication.class, args);
	}
}
