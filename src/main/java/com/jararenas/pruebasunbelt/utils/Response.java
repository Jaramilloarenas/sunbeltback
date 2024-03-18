package com.jararenas.pruebasunbelt.utils;

import java.util.List;

import com.jararenas.pruebasunbelt.models.Customer;

public class Response {
	private String response;
	private List<Customer> customers;
	
	public Response(String message, List<Customer> customers) {
		this.response = message;
		this.customers = customers;
	}
	
	public Response() {
		
	}
	
	public String getResponse() {
		return response;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void setResponse(String message) {
		this.response = message;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
