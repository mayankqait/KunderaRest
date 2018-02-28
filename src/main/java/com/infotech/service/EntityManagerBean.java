package com.infotech.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

@Configuration
@EnableTransactionManagement
@PersistenceContext(type=javax.persistence.PersistenceContextType.EXTENDED)
public class EntityManagerBean {
	
	public EntityManagerFactory emf;
	
    @Transactional
	@Bean
	public EntityManager getEntityManagerBean() {
		 emf =Persistence.createEntityManagerFactory("mysqlPU,cassandra_pu");
	    EntityManager em = emf.createEntityManager(SynchronizationType.UNSYNCHRONIZED);
	    return em;
	}
    
    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
