package com.jararenas.pruebasunbelt.services;

import java.util.List;

import com.jararenas.pruebasunbelt.models.Customer;

/**
 * 
 */
public interface IDataService {
	
	/**
	 * 
	 * @param cus
	 * @return
	 */
	public List<Customer> getCustomerByDoc(Customer cus);
	
}
