package com.cg.mypaymentapp.beans;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
	private static Map<String, Customer> customer;
	public static Map<String, Customer> createCollection()
	{
		if (customer == null)
			customer = new HashMap<>();
		return customer;
	}
}
