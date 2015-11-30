package com.sg.members;


import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sg.members.repository.impl")
public class SgmembersApplication {
	
	
    public static void main(String[] args)
    {
        SpringApplication.run(SgmembersApplication.class, args);
    }
    
    
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }
}
