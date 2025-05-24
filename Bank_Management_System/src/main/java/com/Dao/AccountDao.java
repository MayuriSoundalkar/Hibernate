package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Account;
import com.Entity.Address;

public class AccountDao {

	public static void addAccount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account a = new Account();
		a.setBalance(5000);
		a.setCredit_Score(600);
		
		et.begin();
		em.persist(a);
		et.commit();
	}
	
	public static void updateAccountById(int a_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account a = em.find(Account.class,a_id);
		a.setBalance(8000);
		
		et.begin();
		em.merge(a);
		et.commit();
	}
	
	public static void deleteById(int a_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account a = em.find(Account.class,a_id);
		
		et.begin();
		em.remove(a);
		et.commit();
	}
	
	public static void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select a from Account a";
		Query query = em.createQuery(jpql);
		List<Account> li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
}
