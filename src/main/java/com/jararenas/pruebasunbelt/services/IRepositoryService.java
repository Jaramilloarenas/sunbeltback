package com.jararenas.pruebasunbelt.services;

import java.util.List;
import java.util.Optional;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.utils.Response;

public interface IRepositoryService {
	public List<Customer> getCustomersByDocument(Customer cus);
	public Optional<Response>  verifyData(Customer cus);
}
