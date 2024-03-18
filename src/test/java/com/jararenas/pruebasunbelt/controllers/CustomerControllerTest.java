package com.jararenas.pruebasunbelt.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
	/*ResponseEntity<Response> response;
	Customer customer;*/
	
	@BeforeEach
	void setup() {
	}
	
	/**
	 * Casos de prueba para el método 
	 * getCustomerById en CustomerController
	 */
	@Test
	@SuppressWarnings("unchecked")
	void testGetCustomerById(){
		ResponseEntity<Response> response;
		/*************************************caso de prueba*****************************************/
		Customer customer = new Customer();
		response = (ResponseEntity<Response>) customerController.getCustomerById(customer);
		Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("c");
		customer.setDocument("10121314");
		response = (ResponseEntity<Response>) customerController.getCustomerById(customer);
		Assertions.assertEquals("OK", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("t");
		response = (ResponseEntity<Response>) customerController.getCustomerById(customer);
		Assertions.assertEquals("El tipo de documento ingresado no es valido", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("p");
		response = (ResponseEntity<Response>) customerController.getCustomerById(customer);
		Assertions.assertEquals("No se encontraron clientes", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("");
		response = (ResponseEntity<Response>) customerController.getCustomerById(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setDocument("");
		response = (ResponseEntity<Response>) customerController.getCustomerById(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
	
	@Test
	void testGetCustomerByDoc() {
		ResponseEntity<Response> response;
		/*************************************caso de prueba*****************************************/
		Customer customer = new Customer();
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("c");
		customer.setDocument("10121314");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("OK", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("t");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("El tipo de documento ingresado no es valido", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("p");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("No se encontraron clientes con los datos proporcionados", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setTypeDoc("");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		/*************************************caso de prueba*****************************************/
		customer.setDocument("");
		response = customerController.getCustomerByDoc(customer);
		Assertions.assertEquals("Los datos de consulta no estan completos", response.getBody().getResponse());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
