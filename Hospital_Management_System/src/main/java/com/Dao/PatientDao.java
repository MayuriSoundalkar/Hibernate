package com.Dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Branch;
import com.Entity.Patient;

public class PatientDao {

	public static void addPatient() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		    
		Patient p = new Patient();
	    p.setName("Mamta");
	    p.setMedicalHistory("Cancer");
	    p.setDob(LocalDate.of(2000,4,11));
	    
	    et.begin();
	    em.persist(p);
	    et.commit();
	}
	
	public static void findAllPatient() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "Select p from Patient p";
		Query query = em.createQuery(jpql);
		List li = query.getResultList();
		li.forEach(al ->System.out.println(al));
		
	}
	
	public static void updateById(int p_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Patient p = em.find(Patient.class, p_id);
	    p.setMedicalHistory("Fracture");
		
		et.begin();
		em.merge(p);
		et.commit();
	}
	
	public static void deleteById(int p_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Patient p = em.find(Patient.class, p_id);
		et.begin();
		em.remove(p);
		et.commit();
	}
}
