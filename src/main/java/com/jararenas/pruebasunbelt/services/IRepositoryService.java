package com.jararenas.pruebasunbelt.services;

import java.util.List;

import com.jararenas.pruebasunbelt.models.Customer;

public interface IRepositoryService {
	public List<Customer> getCustomersByDocument(Customer cus);
}
