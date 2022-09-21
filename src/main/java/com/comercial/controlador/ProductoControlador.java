package com.comercial.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.comercial.core.facade.ProductoFacade;
import com.comercial.dto.ProductosDTO;
import com.comercial.entidades.CustomersEntity;
import com.comercial.entidades.Productos;
import com.comercial.repositorio.CustomersRepository;
import com.comercial.repositorio.ProductosRepositorio;
import com.comercial.response.Response;
import com.comercial.utils.excepcion.CustomException;
import com.comercial.utils.httpstatus.RestResponse; 

@RestController
@RequestMapping("/api/v1")
public class ProductoControlador {
	
	  
	@Autowired
	private ProductoFacade productoFacade;
	
	@Autowired
	ProductosRepositorio productosRepositorio;
	
	@Autowired
	RestResponse restResponse;
	
	
	
	
	public static final String GREATER_THAN="greater";
	public static final String LESS_THAN="less";
	public static final String EQUAL="equal";
	
	@GetMapping("/consultaAvanzada")
	public List<Productos> getData(@RequestParam(required=false,name="idProducto") Integer idProducto,
			                             @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate,
                                         @RequestParam(required=false) String dateCondition	,
			                             @RequestParam(value="codigoProducto",required=false) String codigoProducto,
			                             @RequestParam(value="nombreProducto",required=false) String nombreProducto,
			                             @RequestParam(value="stock",required=false) Integer stock,
			                             @RequestParam(value="precioUnitario",required=false) Integer precioUnitario
			                             		)
	{		
		
		
		HashMap<String, Object> data=new HashMap<>();
		
		if (idProducto!=null)
			data.put("idProducto",idProducto);
		if (codigoProducto!=null)
			data.put("codigoProducto",codigoProducto);
		if (nombreProducto!=null)
			data.put("nombreProducto",nombreProducto);
		if (stock!=null)
			data.put("stock",stock);
		if (precioUnitario!=null)
			data.put("precioUnitario",precioUnitario);
		
		if (dateCondition==null)
			dateCondition=GREATER_THAN;
		if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
			dateCondition=GREATER_THAN;	
		if (createdDate!=null)
		{
			data.put("created",createdDate);
			data.put("dateCondition",dateCondition);
		} 
		return productosRepositorio.getData(data);			
	}
	
	
	
	
	
	
	@GetMapping("/listarTodosLosProductos/")
	public ResponseEntity<List<Productos>> listarTodosLosProductos(){
		ResponseEntity<List<Productos>> response = null;
		
		try {
			response = new ResponseEntity<>( productoFacade.listarTodosLosProductos(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@GetMapping("/listarTodoConPaginacion")
	public ResponseEntity<List<Productos>> listarTodoConPaginacion(@RequestParam(value="pageNo",defaultValue="0",required=false) int pageNo,
			                                  @RequestParam(value="cantidadRegistro", defaultValue="10", required=false) int cantidadRegistro,
			                                  @RequestParam(value="sortBy",defaultValue ="idProducto",required=false) String idProducto	,
			                                  @RequestParam(value="sortDir", defaultValue="asc", required=false) String sortDir ){
		ResponseEntity<List<Productos>> response = null;
		
		try {
			response = new ResponseEntity<>( productoFacade.listarTodoConPaginacion(pageNo, cantidadRegistro,idProducto,sortDir), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	
	 
	@GetMapping("/listarPorCodigoProductos/")
	public ResponseEntity<List<Productos>> listarPorCodigoProductos(@RequestParam(value="codigoProducto") String codigoProducto ){
		
		ResponseEntity<List<Productos>> response = null;
		 
		
		try {
			//response = new ResponseEntity<>( productoFacade.listarPorCodigoProductos(codigoProducto), HttpStatus.OK);
			List<Productos> listaProductos = productoFacade.listarPorCodigoProductos(codigoProducto);
			
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
	
	
	
	
	
	@GetMapping("/buscarProductoCodigoStock/")
	public   ResponseEntity<List<Productos>>  buscarProductoCodigoStock(@RequestParam(value="codigoProducto") String codigoProducto,
			                                                      @RequestParam(value="stock") int stock){
		ResponseEntity<List<Productos>>  response = null;
		
		try {
			response = new ResponseEntity<>( productoFacade.buscarProductoCodigoStock(codigoProducto,stock), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@PostMapping("/guardarProducto")
	public ResponseEntity<Response> guardarProducto(@RequestBody ProductosDTO productos){
		ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( productoFacade.guardarProducto(productos), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	
	@PutMapping("/editarProducto")
	public ResponseEntity<Response> EditarProducto(@RequestBody ProductosDTO productos){
		ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( productoFacade.editarProducto(productos), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}
	
	
	
	@DeleteMapping("/eliminar/{codigoProducto}")
	public ResponseEntity<Response> eliminarProducto(@PathVariable String codigoProducto){
         ResponseEntity<Response> response = null;
		
		try {
			response = new ResponseEntity<>( productoFacade.eliminarProductoCodigo(codigoProducto), HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage().toString();
		} 
		return response; 
		
	}
	
	
	
	

}
