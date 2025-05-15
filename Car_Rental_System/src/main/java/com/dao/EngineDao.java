package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Engine;

public class EngineDao {

	public static void addEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
		e.setHorsepower(360);
		e.setType("Electric Dual Motor");
		
		et.begin();
		em.persist(e);
		et.commit();
		System.out.println("Data added into engine");
	}
	
	public static void removeEngine(int e_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Engine  e = em.find(Engine.class, e_id);
		em.remove(e);
		et.commit();
	}
	
	public static void findAllEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		String jpql = "Select e from Engine e";
		Query query = em.createQuery(jpql);
		List<Engine> li = query.getResultList();
		li.forEach(al->System.out.println(al));
	}
	
	
}
