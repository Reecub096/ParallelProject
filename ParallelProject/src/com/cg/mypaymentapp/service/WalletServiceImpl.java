package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService{
	
	WalletRepo wallet;
	Map<String, Wallet> walletMap;
	
	public WalletServiceImpl() {
		// TODO Auto-generated constructor stub
		wallet = new WalletRepoImpl();
		walletMap = new HashMap<>();
	}
	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Wallet wallet = new Wallet(amount);
		customer.setName(name);
		customer.setMobileNo(mobileno);
		customer.setWallet(wallet);
		walletMap.put(mobileno, wallet);
		return customer;
	}

	@Override
	public Customer showBalance(String mobileno) {
		// TODO Auto-generated method stub
		Wallet wallet = walletMap.get(mobileno);
		
		return null;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
