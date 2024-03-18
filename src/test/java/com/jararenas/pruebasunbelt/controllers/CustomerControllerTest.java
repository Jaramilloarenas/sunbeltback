package com.jararenas.pruebasunbelt.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jararenas.pruebasunbelt.dataaccess.Data;
import com.jararenas.pruebasunbelt.dataaccess.Repository;
import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.utils.Response;

class CustomerControllerTest {

	Repository service = new Repository(new Data());
	CustomerController customerController = new CustomerController(service);
	
	@Test
	void testGetCustomerByDoc() {
		ResponseEntity<Response> response;
		Customer customer = new Customer();
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		customer.setTypeDoc("c");
		customer.setDocument("10121314");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("OK", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		/* Another test */ 
		customer.setTypeDoc("t");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("El tipo de documento ingresado no es valido", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		customer.setTypeDoc("p");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("No se encontraron clientes con los datos proporcionados", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		customer.setTypeDoc("");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		customer.setDocument("");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	@Test
	void testGetCustomerByDocument() {
		ResponseEntity<Response> response;
		Customer customer = new Customer();
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		customer.setTypeDoc("c");
		customer.setDocument("10121314");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("OK", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		/* Another test */ 
		customer.setTypeDoc("t");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("El tipo de documento ingresado no es valido", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		customer.setTypeDoc("p");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("No se encontraron clientes con los datos proporcionados", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		customer.setTypeDoc("");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		customer.setDocument("");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
	
	@Test
	void testTesting() {
		Assertions.assertEquals("Verificado", customerController.testing());
	}

}
