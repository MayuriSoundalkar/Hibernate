package com.Util;

import javax.persistence.Persistence;

public class Connection {

	 public static void main(String[] args) {
	    	Persistence.createEntityManagerFactory("postgres");
	 }
}
