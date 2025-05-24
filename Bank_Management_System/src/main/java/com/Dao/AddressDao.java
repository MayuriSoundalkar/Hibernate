package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Address;
import com.Entity.Customer;

public class AddressDao {

	public static void addAddress() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Address a = new Address();
		a.setState("Himachal Pradesh");
		
		et.begin();
		em.persist(a);
		et.commit();
	}
	
	public static void updateAddressById(int a_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Address a = em.find(Address.class,a_id);
		a.setState("Kashmir");
		
		et.begin();
		em.merge(a);
		et.commit();
	}
	
	public static void deleteById(int a_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Address a = em.find(Address.class,a_id);
		
		et.begin();
		em.remove(a);
		et.commit();
	}
	
	public static void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select a from Address a";
		Query query = em.createQuery(jpql);
		List<Address> li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
}
