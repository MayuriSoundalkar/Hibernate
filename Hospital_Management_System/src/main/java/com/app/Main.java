package com.app;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.Dao.BranchDao;
import com.Dao.HospitalDao;
import com.Dao.PatientDao;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give choice to perform operation");
		System.out.println("1. Add data into Hospital,branch,patient");
		System.out.println("2. Add data into hospital");
		System.out.println("3. Add data into branch");
		System.out.println("4. Add data into patient");
		System.out.println("5. Find all data from hospital");
		System.out.println("6. Update hospital data using id");
		System.out.println("7. Delete using id");
		
		System.out.println("8. Find all data from branch");
		System.out.println("9. Update branch data using id");
		System.out.println("10. Delete branch id");
		
		System.out.println("11. Find all data from patient");
		System.out.println("12. Update patient data using id");
		System.out.println("13. Delete patient using id");
		
		int choice= sc.nextInt();
		sc.nextLine();
		
		switch(choice){
			
		case 1 : HospitalDao.addData();
		         break;
		case 2 : HospitalDao.addHospital();
		         break;
		case 3 : BranchDao.addBranch();
                 break;
		case 4 : PatientDao.addPatient();
		         break;
		case 5 : HospitalDao.findAllHospital();
		         break;
		case 6 : HospitalDao.updateById(2);
		         break;
		case 7 : HospitalDao.deleteById(3);
		         break;
		         
		case 8 : BranchDao.findAllBranch();
                 break;
        case 9 : BranchDao.updateById(110);;
                 break;
        case 10 :BranchDao.deleteById(110);;
                 break;
                 
        case 11 : PatientDao.findAllPatient();
                 break;
        case 12 : PatientDao.updateById(211);;
                 break;
        case 13 : PatientDao.deleteById(211);
                 break;
                 
         
		default :System.out.println("Invalid choice");;
		}
	}

	
}
