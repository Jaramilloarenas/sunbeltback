package com.jararenas.pruebasunbelt.services;

import java.util.List;

import com.jararenas.pruebasunbelt.models.Customer;

public interface IDataService {
	
	public List<Customer> getCustomerByDoc(Customer cus);
	
}
