package com.cg.mypaymentapp.service;

import java.util.HashMap;
import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService{
	
		WalletRepo wallet;
		Map<String, Customer> walletMap;
	
		public WalletServiceImpl() {
				// TODO Auto-generated constructor stub
				wallet = new WalletRepoImpl();
				walletMap = new HashMap<>();
		}

		@Override
		public Customer showBalance(String mobileno) {
				// TODO Auto-generated method stub
				Customer cust = walletMap.get(mobileno);
				return cust;
		}

		@Override
		public void fundTransfer(String sourceMobileNo, String targetMobileNo,Double amount) {
				// TODO Auto-generated method stub
				Customer source = walletMap.get(sourceMobileNo);
				Customer target = walletMap.get(targetMobileNo);
				if (amount > 0) {
						if((source.getAmount() - amount) >= 0)
						{	
								double bal1 = target.getAmount();
								bal1 += amount;
								target.setAmount(bal1);
								walletMap.put(targetMobileNo, target);
								double bal2 = source.getAmount();
								bal2 -= amount;
								source.setAmount(bal2);
								walletMap.put(sourceMobileNo, source);
						}
						else {
								throw new InsufficientBalanceException("Balance should be higher than amount to be transferred !!!! ");
						}
				}
				else 
						throw new InvalidInputException("Amount should be positive to send");
		}


		@Override
		public Customer withdrawAmount(String mobileNo, Double amount) {
				// TODO Auto-generated method stub
				Customer customer = walletMap.get(mobileNo);
				if(amount > 0) {
						if((customer.getAmount() - amount) >= 0)
						{
								customer.setAmount(customer.getAmount() - amount);
								return customer;
						}
						else 
								throw new InsufficientBalanceException("Balance is not sufficient for this withdrawl amount");
				}
				else 
						throw new InvalidInputException("Amount cannot be Negative ");
		}

		@Override
		public Customer depositAmount(String mobileNo, Double amount) {
				// TODO Auto-generated method stub
				Customer customer = walletMap.get(mobileNo);
				if (amount > 0) {
						double bal = customer.getAmount();
						bal += amount;
						customer.setAmount(bal);
						return customer;
				}
				else 
						throw new InvalidInputException("Amount should be positive");
		}

		@Override
		public Customer createAccount(Customer customer) {
			// TODO Auto-generated method stub
			walletMap.put(customer.getMobileNo(), customer);
			return customer;
		}
	
}
