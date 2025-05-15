package com.util;

import javax.persistence.Persistence;

public class DBConnection {
	 public static void main(String[] args) {
	    	Persistence.createEntityManagerFactory("postgres");
	 }
}
