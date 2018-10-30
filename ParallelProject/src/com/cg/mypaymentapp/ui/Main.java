package com.cg.mypaymentapp.ui;

import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		
		WalletService service = new WalletServiceImpl();
		Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		String custName;
		double amount;
		String mobNum;
		int ch;
		do {
				System.out.println("1. Create Customer Acoount ");
				System.out.println("2. Balance show ");
				System.out.println("3. Fund transfer ");
				System.out.println("4. Withdraw ");
				System.out.println("5. Deposit ");
				System.out.println("6. Exit ");
				System.out.print("Enter your choice : ");
				ch = sc.nextInt();
				switch (ch) {
				
				case 1: 
						
						System.out.print(" Enter the customer name : ");
						custName = sc.next();
						System.out.print(" Enter the customer mobile number : ");
						mobNum = sc.next();
						System.out.print(" Enter the initial balance : ");
						amount = sc.nextDouble();
						customer.setName(custName);
						customer.setMobileNo(mobNum);
						customer.setAmount(amount);
						service.createAccount(customer);
						break;
				
				case 2 : 
					
						System.out.print(" Enter the customer mobile number : ");
						mobNum = sc.next();
						service.showBalance(mobNum);
						System.out.println(" Name : " + customer.getName());
						System.out.println(" Mobile Number : " + customer.getMobileNo());
						System.out.println(" Balance : " + customer.getAmount());
						break;
					
				case 3 :
						
						System.out.print(" Enter the Sender Phone Number : ");
						String mob1 = sc.next();
						System.out.print("Enter the Receiver Phone Number : ");
						String mob2 = sc.next();
						System.out.print(" Enter the amount to be transferred : ");
						amount = sc.nextDouble();
						service.fundTransfer(mob1, mob2, amount);
						System.out.println(" Transferred Successfully !!! ");
						break;
						
				case 4 :
					
						System.out.print(" Enter the Customer mobile Number : ");
						mobNum = sc.next();
						System.out.println("Enter the amount to be withdrawn : ");
						amount = sc.nextDouble();
						service.withdrawAmount(mobNum, amount);
						System.out.println(amount + " Withdrawn \n Balance : " + customer.getAmount());
						break;
						
				case 5 :
						System.out.println(" Enter the Customer mobile number : ");
						mobNum = sc.next();
						System.out.println(" Enter the amount to be deposited : ");
						amount = sc.nextDouble();
						service.depositAmount(mobNum, amount);
						System.out.println(amount + " Deposited \n Balance : " + customer.getAmount());
						break;
				}
		}while(ch != 6);
		System.out.println("Program Ended successfully !!!! ");
	}

}
