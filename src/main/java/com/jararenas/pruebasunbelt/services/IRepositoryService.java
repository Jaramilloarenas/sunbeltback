package com.jararenas.pruebasunbelt.services;

import java.util.List;
import java.util.Optional;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.utils.Response;

public interface IRepositoryService {
	/**
	 * 
	 * @param cus
	 * @return
	 */
	public List<Customer> getCustomersByDocument(Customer cus);
	
	/**
	 * 
	 * @param cus
	 * @return
	 */
	public Response getCustomersByDoc(Customer cus);
	
	/**
	 * 
	 * @param cus
	 * @return
	 */
	public Optional<Response>  verifyData(Customer cus);
}
