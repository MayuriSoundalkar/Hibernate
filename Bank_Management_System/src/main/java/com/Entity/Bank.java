package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Bank {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "bank_no")
    @SequenceGenerator(name="bank_no",initialValue=400,allocationSize=1)
	private int id;
	private String name;
	private String location;
	private String branch;
}
