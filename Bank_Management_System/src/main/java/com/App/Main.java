package com.App;

import java.util.Scanner;

import com.Dao.AccountDao;
import com.Dao.AddressDao;
import com.Dao.BankDao;
import com.Dao.CustomerDao;

public class Main {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("==== BANK MANAGEMENT SYSTEM ====");
	        System.out.println("1. Add Customer(includes Bank,Account and Address data also)");
	        System.out.println("2. Add only Customer");
	        System.out.println("3. Allocate account number to customer");
	        System.out.println("4. Deallocate account number from customer");
	        System.out.println("5. Allocate bank id from customer");
	        System.out.println("6. Deallocate bank id from customer");
	        System.out.println("7. Find all the details of customer");
	        System.out.println("8. Find according to customer id");
	        System.out.println("9 . Delete according to customer id");
	        
	        System.out.println("10. Add only bank");
	        System.out.println("11. Update bank details");
	        System.out.println("12. Delete bank using id");
	        System.out.println("13. Find all details of bank");
	        
	        System.out.println("14. Add only address");
	        System.out.println("15. Update address details");
	        System.out.println("16. Delete address using id");
	        System.out.println("17. Find all details of address");
	        
	        System.out.println("18. Add only address");
	        System.out.println("19. Update address details");
	        System.out.println("20. Delete address using id");
	        System.out.println("21. Find all details of address");
	        int choice = sc.nextInt();
	        sc.nextLine();  
	        
	        switch(choice) {
	        case 1:CustomerDao.addData();
	        break;
	        case 2:CustomerDao.addCustomer();
	        break;
	        case 3:CustomerDao.allocate_ac(100, 2);
	        break;
	        case 4 :CustomerDao.deallocate_ac(2);
	        break;
	        case 5 :CustomerDao.allocate_bank_id(400, 2);
	        break;
	        case 6 :CustomerDao.deallocate_bank_id(2);
	        break;
	        case 7 :CustomerDao.findAll();
	        break;
	        case 8 :CustomerDao.findById(2);
	        break;
	        case 9 :CustomerDao.deleteById(2);
	        break;
	        
	        case 10 :BankDao.addBank();
	        break;
	        case 11 :BankDao.updateBankById(401);
	        break;
	        case 12 :BankDao.deleteById(401);
	        break;
	        case 13 :BankDao.findAll();
	        break;
	        
	        case 14 :AddressDao.addAddress();
	        break;
	        case 15 :AddressDao.updateAddressById(1002);
	        break;
	        case 16 :AddressDao.deleteById(1002);
	        break;
	        case 17 :AddressDao.findAll();
	        break;
	        
	        case 18 :AccountDao.addAccount();
	        break;
	        case 19 :AccountDao.updateAccountById(101);
	        break;
	        case 20 :AccountDao.deleteById(101);
	        break;
	        case 21 :AccountDao.findAll();
	        break;
	        default : System.out.println("Invalid choice");
	        }
	 }
}
