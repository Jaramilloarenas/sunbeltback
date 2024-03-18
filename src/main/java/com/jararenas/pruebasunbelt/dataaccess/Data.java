package com.jararenas.pruebasunbelt.dataaccess;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.services.IDataService;


/**
* Clase falsa
* Clase para simulación de consulta de datos
* @author Andrés Jaramillo / Sunbelt
* @version 0.1, 06/03/2024
*/
@Service
 public class Data implements IDataService{
	
	//Attributes
	private List<Customer> customers;

	//setters and getters ///////////////////////////////
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	//Constructors///////////////////////////////

	public Data() {
		Customer customer = new Customer();
		customers = new ArrayList<>();
		customer.setTypeDoc("c");
		customer.setDocument("10121314");
		customer.setFirstName("Pepito");
		customer.setSecondName("Pedro");
		customer.setSurname("Perez");
		customer.setSecondSurname("Marin");
		customer.setTelephone("3013815241");
		customer.setCity("Medellin");
		customer.setAddress("Cr 8b # 32c - 3");
		customers.add(customer);
		
	}
	
	public List<Customer> getCustomerByDoc(Customer cus){
		List<Customer> res = (List<Customer>) this.customers.stream().filter(x -> x.getDocument().equals(cus.getDocument()) 
				&& x.getTypeDoc().equals(cus.getTypeDoc().toLowerCase())).collect(Collectors.toList());;
		return res;
	}
	
	

}
