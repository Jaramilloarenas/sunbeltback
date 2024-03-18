package com.jararenas.pruebasunbelt.dataaccess;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.services.IRepositoryService;
import com.jararenas.pruebasunbelt.utils.Response;

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
		cus.setTypeDoc(cus.getTypeDoc().toLowerCase());
		return data.getCustomerByDoc(cus);
	}


	public Optional<Response> verifyData(Customer cus) {
		cus.setTypeDoc(cus.getTypeDoc().toLowerCase());
		if(cus.getTypeDoc().isEmpty() || cus.getDocument().isEmpty())
			return Optional.of(new Response("Los datos de consulta no estan completos", null));
		if(!cus.getTypeDoc().equals("c") && !cus.getTypeDoc().equals("p")) 
			return Optional.of(new Response("El tipo de documento ingresado no es valido", null));
		return Optional.empty();
	}

}
