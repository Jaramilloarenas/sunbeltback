package com.jararenas.pruebasunbelt.dataaccess;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.services.IRepositoryService;

@Service
public class Repository implements IRepositoryService{
	
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public Repository(Data data) {
		this.data = data;
	}
	
	@Override
	public List<Customer> getCustomersByDocument(Customer cus) {
		return data.getCustomerByDoc(cus);
	}
	
	
	
	
	
	
	
	
}
