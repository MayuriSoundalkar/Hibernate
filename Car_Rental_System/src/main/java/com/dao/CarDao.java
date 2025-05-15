package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Customer;
import com.entity.Engine;

public class CarDao {
	
	
	public static void addData() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = new Car();
		c.setColor("White");
		c.setModel("BMW 330i");
		c.setRegister_date(LocalDate.of(2024, 1, 1));
		
		Engine e = new Engine();
		e.setHorsepower(320);
		e.setType("Inline-4 Turbocharged");
		
		Customer cus = new Customer();
		cus.setC_loc("Chicago");
		cus.setC_name("Smith");
		
		c.setEngine(e);
		c.setCustomer(cus);
		et.begin();
		em.persist(e);
		em.persist(cus);
		em.persist(c);
		et.commit();
		System.out.println("Data added into car");
	}
	
	public static void deleteById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		String jpql ="delete Car c where id = ?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, id);
		int count = query.executeUpdate();
		System.out.println(count);
		et.commit();
	}
	
	public static void findAllCar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select c from Car c";
		Query query = em.createQuery(jpql);
		List<Car> li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
	
	public static void findByregisterDate(LocalDate date) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select c from Car c where c.register_date = ?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, date);
		List<Car> li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
	
	public static void allocateEngine(int e_id,int c_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = em.find(Car.class, c_id);
		Engine e = em.find(Engine.class, e_id);
		
		c.setEngine(e);
		et.begin();
		em.merge(e);
		et.commit();
	}
	
	public static void dealloateEngine(int c_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = em.find(Car.class, c_id);
		c.setEngine(null);
		
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public static void allocateCustomer(int cus_id,int c_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = em.find(Car.class, c_id);
		Customer cus = em.find(Customer.class, cus_id);
		
		c.setCustomer(cus);
		et.begin();
		em.merge(cus);
		et.commit();
	}
	
	public static void deallocateCustomer(int c_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = em.find(Car.class, c_id);
		c.setCustomer(null);
		et.begin();
		em.merge(c);
		et.commit();
	}
}
