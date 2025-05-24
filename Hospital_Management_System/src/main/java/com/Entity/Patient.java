package com.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "patient_id")
	@SequenceGenerator(name= "patient_id",initialValue=300,allocationSize=1)
	private int patientId;
	private String name;
	private LocalDate dob;
	private String medicalHistory;
}
