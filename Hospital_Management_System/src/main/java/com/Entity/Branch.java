package com.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="branch_id")
	@SequenceGenerator(name="branch_id",initialValue=100,allocationSize=1)
	private int branchId;
	private String location;
	private long phone_no;
	
	@OneToMany
	List <Patient> patient;
}
