package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Bank;

public class BankDao {

	public static void addBank() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank b = new Bank();
		b.setName("SBI");
		b.setLocation("Akurdi");
		b.setBranch("Pune");
		
		et.begin();
		em.persist(b);
		et.commit();
	}
	
	public static void updateBankById(int b_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank b = em.find(Bank.class, b_id);
		b.setBranch("SBI");
		b.setName("SBI Bank");
		
		et.begin();
		em.merge(b);
		et.commit();
	}
	
	public static void deleteById(int b_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank b = em.find(Bank.class, b_id);
		et.begin();
		em.remove(b);
		et.commit();
	}
	
	public static void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select b from Bank b";
		Query query = em.createQuery(jpql);
		List<Bank> li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
}
