package com.jararenas.pruebasunbelt.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	/**
	* Método de prueba de fácil acceso a traves de un cliente
	* @author Andrés Jaramillo / Sunbelt
	* @version 0.1, 06/03/2024
	*/
	@GetMapping("/testing")
	public String testing(){
		System.out.println("Verificando si la aplicación inicia en el puerto indicado");
		return "Verificado";
	}
	
	public CustomerController(IRepositoryService service) {
		this.service = service;
	}
	
	/**
	* Método expuesto para ser consumido por el método post para obtener los clientes con un determinado documento
	* @param customer recibe dos valores de tipos String, uno con el tipo de documento y el otro con el documento 
	* @return Retorna un objeto con dos atributos, unos de tipos String para mostrar un mensaje acerca del resultado de la ejeución
	* y otro con los resultados
	* @author Andrés Jaramillo / Sunbelt
	* @version 0.1, 06/03/2024
	*/
	
	@CrossOrigin
	@PostMapping("getCustomerByDoc")
	public ResponseEntity<Response> getCustomerByDoc(@RequestBody Customer customer){
		logger.debug("the method getCustomerByDoc() has been initialized");
		Response response = new Response(); 
		try {
			customer.setTypeDoc(customer.getTypeDoc().toLowerCase());
			if(customer.getTypeDoc().isEmpty() || customer.getDocument().isEmpty()) {
				response.setResponse("Los datos de consulta no estan completos");
				logger.warn("The data received is not complete");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			if(!customer.getTypeDoc().equals("c") && !customer.getTypeDoc().equals("p")) {
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
			logger.info("Request completed");
			return new ResponseEntity<>(new Response("OK", res), HttpStatus.OK);
		}
		catch(Exception ex) {
			logger.error("ex.getMessage()", ex);
			response.setResponse(ex.getMessage());
			response.setCustomers(null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	////@CrossOrigin(origins = http://localhost:9001 @RequestParam(required = false, defaultValue = "World")
	//@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	
	/**
	* Otra versión del método getCustomerByDoc(@RequestBody Customer customer)
	* Una prueba para revisar que tanto podía compactar el código para "dismminuir" la "verbosidad"
	* @param customer recibe dos valores de tipos String, uno con el tipo de documento y el otro con el documento 
	* @return Retorna un objeto con dos atributos, unos de tipos String para mostrar un mensaje acerca del resultado de la ejeución
	* y otro con los resultados
	* @author Andrés Jaramillo / Sunbelt
	* @version 0.1, 06/03/2024
	*/
	@PostMapping("getCustomerByDocument")
	public ResponseEntity<Response> getCustomerByDocument(@RequestBody Customer customer){
		try {
			customer.setTypeDoc(customer.getTypeDoc().toLowerCase());
			if(customer.getTypeDoc().isEmpty() || customer.getDocument().isEmpty())
				return new ResponseEntity<>(new Response("Los datos de consulta no estan completos", null), HttpStatus.BAD_REQUEST); 
			if(!customer.getTypeDoc().equals("c") && !customer.getTypeDoc().equals("p"))
				return new ResponseEntity<>(new Response("El tipo de documento ingresado no es valido", null), HttpStatus.BAD_REQUEST); 
			List<Customer> res = service.getCustomersByDocument(customer);
			if(res.isEmpty())
				return new ResponseEntity<>(new Response("No se encontraron clientes con los datos proporcionados", null), HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(new Response("OK", null), HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(new Response(ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*HttpHeaders responseHeaders = new HttpHeaders();
	   responseHeaders.setLocation(location);
	   responseHeaders.set("MyResponseHeader", "MyValue");*/
	
	
	
	
	
}
