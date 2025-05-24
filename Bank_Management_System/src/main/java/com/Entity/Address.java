package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Entity
@Data
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "pin_no")
    @SequenceGenerator(name="pin_no",initialValue=1000,allocationSize=1)
	private int pincode;
	private String state;
	
}
