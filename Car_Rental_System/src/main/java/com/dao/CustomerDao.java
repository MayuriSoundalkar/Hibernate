package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Customer;

public class CustomerDao {
    public static void addCustomer() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Customer c = new Customer();
    	c.setC_loc("San Francisco");
    	c.setC_name("Alice");
    	
    	et.begin();
    	em.persist(c);
    	et.commit();
    	System.out.println("Data added into customer");
    }
    
    public static void removeCustomer(int c_id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Customer c = em.find(Customer.class, c_id);
    	et.begin();
    	em.remove(c);
    	et.commit();
    }
    
    public static void findAllCustomer() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	String jpql = "Select c from Customer c";
    	Query query = em.createQuery(jpql);
        List<Customer> li = query.getResultList();
        li.forEach(al->System.out.println(al));
    }
}
