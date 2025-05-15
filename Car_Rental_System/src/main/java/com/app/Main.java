package com.app;


import java.time.LocalDate;
import java.util.Scanner;

import com.dao.CarDao;
import com.dao.CustomerDao;
import com.dao.EngineDao;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== CAR RENTAL SYSTEM ====");
        System.out.println("1. Add Car(includes engine and customer data also)");
        System.out.println("2.Add engine");
        System.out.println("3.Add customer");
        System.out.println("4. Delete Car");
        System.out.println("5.Get data of all cars");
        System.out.println("6.Get data of cars according to register date");
        System.out.println("7.Allocate new engine id to car");
        System.out.println("8. Deallocate engine id");
        System.out.println("9. Remove engine using id");
        System.out.println("10. Find all engines");
        System.out.println("11. Remove customer using id");
        System.out.println("12. Find all customers");
        System.out.println("13. Allocate new customer id to car");
        System.out.println("14. Deallocate customer id to car");
        System.out.println("Enter choice");
        
        int choice = sc.nextInt();
        sc.nextLine();  

        switch(choice) {
            case 1: 
              CarDao.addData();
              break;
            case 2:
               EngineDao.addEngine();
               break;
            case 3 :
            	CustomerDao.addCustomer();
            	break;
            case 4 :
            	CarDao.deleteById(103);
            	break;
            case 5 :
            	CarDao.findAllCar();
            	break;
            case 6 :
            	CarDao.findByregisterDate(LocalDate.now());
            	break;
            case 7 :
            	CarDao.allocateEngine(3, 102);
            	break;
            case 8 :
            	CarDao.dealloateEngine(102);
            	break;
            case 9 :
            	EngineDao.removeEngine(3);
            	break;
            case 10 :
            	EngineDao.findAllEngine();
            	break;
            case 11 :
            	CustomerDao.removeCustomer(3);
            	break;
            case 12 :
            	CustomerDao.findAllCustomer();
            case 13 :
            	CarDao.allocateCustomer(2, 104);
            	break;
            case 14 :
            	CarDao.deallocateCustomer(104);
            	break;
            
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();  
    }
}
