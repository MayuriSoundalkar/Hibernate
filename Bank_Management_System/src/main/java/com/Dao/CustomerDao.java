package com.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.Account;
import com.Entity.Address;
import com.Entity.Bank;
import com.Entity.Customer;

public class CustomerDao {

	
	public static void addData() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Address a= new Address();
		a.setState("Maharashtra");
		
		Address a1 = new Address();
		a1.setState("Gujrat");
		
		List<Address> li = new ArrayList();
		li.add(a);
		li.add(a1);
		
		Account ac = new Account();
		ac.setBalance(3000);
		ac.setCredit_Score(500);
		
		Bank b = new Bank();
		b.setBranch("IDBI");
		b.setLocation("Kolhapur");
		b.setName("IDBI Bank");
		
		Customer c = new Customer();
		c.setName("Mayuri");
		c.setPhone_no("7387746512");
		c.setDob(LocalDate.of(2001,3,26));
		c.setAccount(ac);
		c.setBank(b);
		c.setAddress(li);
	
		et.begin();
		em.persist(c);
		em.persist(b);
		em.persist(ac);
		em.persist(a);
		em.persist(a1);
		et.commit();
	}
	
	public static void addCustomer() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = new Customer();
		c.setPhone_no("12312313");
		c.setName("Anjali");
		c.setDob(LocalDate.of(1999, 1, 1));
		
		et.begin();
		em.persist(c);
		et.commit();
	}
	
	public static void allocate_ac(int ac_no,int c_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account ac = em.find(Account.class, ac_no);
		Customer c = em.find(Customer.class, c_id);
		c.setAccount(ac);
		
		et.begin();
		em.merge(ac);
		et.commit();
	}
	
	public static void deallocate_ac(int c_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = em.find(Customer.class,c_id);
		c.setAccount(null);
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public static void allocate_bank_id(int bank_id,int cus_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank b = em.find(Bank.class, bank_id);
		Customer c = em.find(Customer.class, cus_id);
		c.setBank(b);
		
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public static void deallocate_bank_id(int cus_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Customer c = em.find(Customer.class, cus_id);
		c.setBank(null);
		
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public static void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select c from Customer c";
		Query query = em.createQuery(jpql);
		List<Customer> li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
	
	public static void findById(int cus_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select c from Customer c where id =?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, cus_id);
		List <Customer>li = query.getResultList();
		li.forEach(al ->System.out.println(al));
	}
	
	public static void deleteById(int cus_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = em.find(Customer.class, cus_id);
		
		et.begin();
		em.remove(c);
		et.commit();
	}
}
