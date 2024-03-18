package com.jararenas.pruebasunbelt.dataaccess;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jararenas.pruebasunbelt.models.Customer;

class DataTest {
	
	Data data;
	
	@BeforeEach
	void setUp() {
		data = new Data();
	}

	@Test
	void testGetCustomerByDoc() {
		List<Customer> list;
		Customer customer = new Customer();
		customer.setTypeDoc("c");
		customer.setDocument("10121314");
		list = data.getCustomerByDoc(customer);
		Assertions.assertEquals(1, list.size());
	}

}
