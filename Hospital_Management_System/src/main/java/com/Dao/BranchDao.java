package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Branch;
import com.Entity.Hospital;

public class BranchDao {

	public static void addBranch() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		    
		Branch b = new Branch();
		b.setLocation("Akurdi");
		b.setPhone_no(1233453);
	  
	    et.begin();
	    em.persist(b);
	    et.commit();
	}
	
	public static void findAllBranch() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "Select b from Branch b";
		Query query = em.createQuery(jpql);
		List li = query.getResultList();
		li.forEach(al ->System.out.println(al));
		
	}
	
	public static void updateById(int b_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Branch b = em.find(Branch.class, b_id);
		b.setLocation("Pune");
		
		et.begin();
		em.merge(b);
		et.commit();
	}
	
	public static void deleteById(int b_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Branch b = em.find(Branch.class, b_id);
		et.begin();
		em.remove(b);
		et.commit();
	}
}
