package com.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Branch;
import com.Entity.Hospital;
import com.Entity.Patient;

public class HospitalDao {

	public static void addData() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	   
	    Patient p1 = new Patient();
	    p1.setName("Savita");
	    p1.setMedicalHistory("diabetes");
	    p1.setDob(LocalDate.of(1989, 3, 24));

	    Patient p2 = new Patient();
	    p2.setName("Geeta");
	    p2.setMedicalHistory("asthma");
	    p2.setDob(LocalDate.of(1991, 5, 27));

	    
	    List<Patient> list1 = new ArrayList<>();
	    list1.add(p1);

	    List<Patient> list2 = new ArrayList<>();
	    list2.add(p2);

	   
	    Branch b1 = new Branch();
	    b1.setLocation("Dange Chowk");
	    b1.setPhone_no(1234567890L);
	    b1.setPatient(list1);

	    Branch b2 = new Branch();
	    b2.setLocation("Kolhapur");
	    b2.setPhone_no(2342342430L);
	    b2.setPatient(list2);

	    
	    List<Branch> branches = new ArrayList<>();
	    branches.add(b1);
	    branches.add(b2);

	    
	    Hospital h = new Hospital();
	    h.setName("Savitribai Phule Hospital");
	    h.setAddress("Pune");
	    h.setBranch(branches);

	    
	    et.begin();
	    em.persist(p1);
	    em.persist(p2);
	    em.persist(b1);
	    em.persist(b2);
	    em.persist(h);
	    et.commit();
	}

	public static void addHospital() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		    
		Hospital h = new Hospital();
		h.setName("DYP hospital");
	    h.setAddress("Akurdi");
	  
	    et.begin();
	    em.persist(h);
	    et.commit();
	}
	
	public static void findAllHospital() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "Select h from Hospital h";
		Query query = em.createQuery(jpql);
		List li = query.getResultList();
		li.forEach(al ->System.out.println(al));
		
	}
	
	public static void updateById(int h_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Hospital h = em.find(Hospital.class, h_id);
		h.setAddress("Dange chawk");
		
		et.begin();
		em.merge(h);
		et.commit();
	}
	
	public static void deleteById(int h_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Hospital h = em.find(Hospital.class, h_id);
		et.begin();
		em.remove(h);
		et.commit();
	}
}
