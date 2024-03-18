package com.jararenas.pruebasunbelt.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.services.IRepositoryService;
import com.jararenas.pruebasunbelt.utils.Response;

@Service
public class Repository implements IRepositoryService{
	
	private static final Logger logger = LoggerFactory.getLogger(Repository.class);
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		//Inyección de dependencia para el servicio de "Acceso a datos"
		this.data = data;
	}
	
	public Repository(Data data) {
		this.data = data;
	}
	
	@Override
	public List<Customer> getCustomersByDocument(Customer cus) {
		logger.info("at the beggining to getCustomersByDocument on Repository class");
		cus.setTypeDoc(cus.getTypeDoc().toLowerCase());
		return data.getCustomerByDoc(cus);
	}
	
	/**
	 * Método que consulta los clientes con los parametros recibidos y prepara un objeto de tipo Response con los datos obtenidos
	* @param customer recibe dos valores de tipos String, uno con el tipo de documento y el otro con el documento 
	* @return Retorna un objeto con dos atributos, unos de tipos String para mostrar un mensaje acerca del resultado de la ejeución
	* y otro con los resultados
	* @author Andrés Jaramillo / Sunbelt
	* @version 1, 18/03/2024
	*/
	@Override
	public Response getCustomersByDoc(Customer cus) {
		logger.info("at the beggining to getCustomersByDoc on Repository class");
		cus.setTypeDoc(cus.getTypeDoc().toLowerCase());
		List<Customer> res = data.getCustomerByDoc(cus);
		if(res.isEmpty()) 
			return new Response("No se encontraron clientes", res);
		return new Response("OK", res);
	}
	
	/**
	 * Metodo para la verificación de los parametros de consulta.
	* @param Deben proporcionartes los atributos document y docType para la verificación de los valores
	* @return Objeto optional con un objeto de tipo Response y un mensaje descriptivo en caso de generarse un error de lo contrario retorna un optional vacio
	* @author Andrés Jaramillo / Sunbelt
	* @version 0.1, 17/03/2024
	*/
	public Optional<Response> verifyData(Customer cus) {
		if(cus.getTypeDoc().isEmpty() || cus.getDocument().isEmpty())
			return Optional.of(new Response("Los datos de consulta no estan completos", new ArrayList<>()));
		cus.setTypeDoc(cus.getTypeDoc().toLowerCase());
		if(!cus.getTypeDoc().equalsIgnoreCase("c") && !cus.getTypeDoc().equalsIgnoreCase("p")) 
			return Optional.of(new Response("El tipo de documento ingresado no es valido", new ArrayList<>()));
		logger.info("call to verifyData on Repository class completed");
		return Optional.empty();
	}

}
