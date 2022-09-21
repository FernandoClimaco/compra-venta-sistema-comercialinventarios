package com.comercial.controlador;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import com.comercial.core.facade.ClientesFacade; 
import com.comercial.entidades.Clientes; 
import com.comercial.response.Response;
import com.comercial.utils.excepcion.CustomException;
import com.comercial.utils.httpstatus.RestResponse;

@RestController
@RequestMapping("/api/vi/clientes")
public class ClientesController {
	
	@Autowired
	private RestResponse restResponse;
	
	@Autowired
	private ClientesFacade clientesFacade;
	
	
	 
	
	@GetMapping("/listarTodosLosClientes/")
	public ResponseEntity<List<Clientes>> listarTodosLosProductos(){
		ResponseEntity<List<Clientes>> response = null;
		
		try {
			response = new ResponseEntity<>( clientesFacade.listarTodosLosClientes(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@GetMapping("/listarTodoConPaginacion")
	public ResponseEntity<List<Clientes>> listarTodoConPaginacion(@RequestParam(value="pageNo",defaultValue="0",required=false) int pageNo,
			                                  @RequestParam(value="cantidadRegistro", defaultValue="10", required=false) int cantidadRegistro,
			                                  @RequestParam(value="sortBy",defaultValue ="idCliente",required=false) String idProducto	,
			                                  @RequestParam(value="sortDir", defaultValue="asc", required=false) String sortDir ){
		ResponseEntity<List<Clientes>> response = null;
		
		try {
			response = new ResponseEntity<>( clientesFacade.listarPorPaginacion(pageNo, cantidadRegistro,idProducto,sortDir), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	
	 
	@GetMapping("/buscarPorCodigoCliente/")
	public ResponseEntity<List<Clientes>> buscarPorCodigoCliente(@RequestParam(value="codigoProducto") String codigoCliente ){
		
		ResponseEntity<List<Clientes>> response = null;
		 
		
		try {
			//response = new ResponseEntity<>( productoFacade.listarPorCodigoProductos(codigoProducto), HttpStatus.OK);
			List<Clientes> listaProductos = clientesFacade.buscarPorCodigoCliente(codigoCliente);
			
			if(listaProductos.isEmpty()) { 
				response = restResponse.createCustomizedResponse(listaProductos, 404,"404", "DATOS no ENCONTRADOS" );  
				//throw new CustomException("404","Datos no encontrados");

			}else {
				response = restResponse.createCustomizedResponse(listaProductos, 200,"200", "DATOS  ENCONTRADOS" ); 
			}
			 
		}
		catch(HttpStatusCodeException e) {
			e.getMessage().toString();
			response = restResponse.createCustomizedResponse(null,e.getRawStatusCode() ,"500", "DATOS no ENCONTRADOS" );
		} catch (CustomException c) {
			throw c;
		}
		return response; 
	}
	
	
	
	
	
	@GetMapping("/buscarPorCodigoYDuiClientes/")
	public   ResponseEntity<List<Clientes>>  buscarPorCodigoYDuiClientes(@RequestParam(value="codigoCliente") String codigoCliente,
			                                                      @RequestParam(value="dui") String dui){
		ResponseEntity<List<Clientes>>  response = null;
		
		try {
			response = new ResponseEntity<>( clientesFacade.buscarPorCodigoYDuiClientes(codigoCliente,dui), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@PostMapping("/guardarClientes")
	public ResponseEntity<Response> guardarClientes(@RequestBody Clientes clientes){
		ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( clientesFacade.guardarClientes(clientes), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@PutMapping("/editarClientes")
	public ResponseEntity<Response> EditarProducto(@RequestBody Clientes clientes){
		ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( clientesFacade.editarClientes(clientes), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	@DeleteMapping("/eliminar/{dui}")
	public ResponseEntity<Response> eliminarCliente(@PathVariable String dui){
         ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( clientesFacade.eliminarClientes(dui), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
		
	}
	
	

}
