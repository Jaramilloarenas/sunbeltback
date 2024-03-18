package com.jararenas.pruebasunbelt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jararenas.pruebasunbelt.models.Customer;
import com.jararenas.pruebasunbelt.services.IRepositoryService;
import com.jararenas.pruebasunbelt.utils.Response;

//más implementaciones

/**
* Clase con la funcioón de controlador con la definición de los métodos expuestos
* @author Andrés Jaramillo / Sunbelt
* @version 0.1, 06/03/2024
*/
@RestController
@RequestMapping("/api/")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	private IRepositoryService service;
	
	public CustomerController(IRepositoryService service) {
		this.service = service;
	}
	
	/**
	* Otra versión del método getCustomerByDoc(@RequestBody Customer customer)
	* Refactorización para mejorar legibilidad del código y hacer una mejor separación de responsabilidades, se creo un nuevo método que realiza las verificaciones de los parametros
	* y retorna un opctional
	* @param customer recibe dos valores de tipos String, uno con el tipo de documento y el otro con el documento 
	* @return Retorna un objeto con dos atributos, unos de tipos String para mostrar un mensaje acerca del resultado de la ejeución
	* y otro con los resultados
	* @author Andrés Jaramillo / Sunbelt
	* @version 1, 06/03/2024
	*/
	@CrossOrigin
	@PostMapping("getCustomerById")
	public ResponseEntity<?> getCustomerById(@RequestBody Customer customer){
		logger.info("initial call");
		try {
			Optional<Response> verification = service.verifyData(customer);
			if(!verification.isEmpty())
				return new ResponseEntity<>(verification.get(), HttpStatus.BAD_REQUEST);
			Response response = service.getCustomersByDoc(customer);
			return new ResponseEntity<>(response, response.getCustomers().isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK );
		}
		catch(Exception ex) {
			logger.error("Error ", ex);
			return new ResponseEntity<>("Error" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Solo pruebas, posibilidad
	 * @param customer
	 * @return
	 */
	@CrossOrigin
	@PostMapping("getCustomerV2")
	public ResponseEntity<String> getCustomerV2(@RequestBody Customer customer){
		logger.info("initial call good");
		try {
			Optional<Response> verification = service.verifyData(customer);
			if(!verification.isEmpty())
				return new ResponseEntity<>(verification.get().getResponse(), HttpStatus.BAD_REQUEST);
			Response response = service.getCustomersByDoc(customer);
			if(response.getCustomers().isEmpty())
				return new ResponseEntity<>(response.getResponse(), HttpStatus.NOT_FOUND );
			return new ResponseEntity<>(response.getResponse() + response.getCustomers().toString(), HttpStatus.OK);
		}
		catch(Exception ex) {
			logger.error("Error ", ex);
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	* @deprecated
	* Método expuesto para ser consumido por el método post para obtener los clientes con un determinado documento
	* @param customer recibe dos valores de tipos String, uno con el tipo de documento y el otro con el documento 
	* @return Retorna un objeto con dos atributos, unos de tipos String para mostrar un mensaje acerca del resultado de la ejeución
	* y otro con los resultados
	* @author Andrés Jaramillo / Sunbelt
	* @version 0.8, 06/03/2024
	*/
	@Deprecated(since="0.8", forRemoval=true)
	@CrossOrigin
	@PostMapping("getCustomerByDoc")
	public ResponseEntity<Response> getCustomerByDoc(@RequestBody Customer customer){
		logger.debug("the method getCustomerByDoc() has been initialized");
		Response response = new Response(); 
		try {
			if(customer.getTypeDoc().isEmpty() || customer.getDocument().isEmpty()) {
				response.setResponse("Los datos de consulta no estan completos");
				logger.warn("The data received is not complete");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			if(!customer.getTypeDoc().equalsIgnoreCase("c") && !customer.getTypeDoc().equalsIgnoreCase("p")) {
				logger.warn("The data received is not valid");
				response.setResponse("El tipo de documento ingresado no es valido");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			List<Customer> res = service.getCustomersByDocument(customer);
			if(res.isEmpty()) {
				response.setResponse("No se encontraron clientes con los datos proporcionados");
				response.setCustomers(null);
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			logger.info("getCustomerByDoc request completed");
			return new ResponseEntity<>(new Response("OK", res), HttpStatus.OK);
		}
		catch(Exception ex) {
			logger.error("ex.getMessage()", ex);
			response.setResponse(ex.getMessage());
			response.setCustomers(null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

	
	
	
	
	
}
