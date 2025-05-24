package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "ac_no")
    @SequenceGenerator(name="ac_no",initialValue=100,allocationSize=1)
	private int acc_no;
	private double balance;
	private double credit_Score;
}
