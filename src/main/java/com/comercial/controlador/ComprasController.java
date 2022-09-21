package com.comercial.controlador;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  
import com.comercial.core.facade.ComprasFacade;
import com.comercial.dto.ComprasDTO;
import com.comercial.entidades.Compras;
import com.comercial.response.Response;

@RestController
@RequestMapping("/compras")
public class ComprasController {
	
	
	@Autowired
	private ComprasFacade comprasFacade;
	
	
	@GetMapping("/listarTodo")
	public ResponseEntity<List<ComprasDTO>> listarTodo(){
		ResponseEntity<List<ComprasDTO>> response  =null;
		  
		try {
			response =  new ResponseEntity<>(comprasFacade.listarTodasLasCompras(), HttpStatus.OK);                  
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return response; 
	}


	
	@GetMapping("/mostrarCompras")
	public ResponseEntity<List<Compras>> listarCompras(){
		ResponseEntity<List<Compras>> response  =null;
		  
		try {
			response =  new ResponseEntity<>(comprasFacade.mostrarListCompras(), HttpStatus.OK);                  
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return response; 
	}
	
	
	
	
	@GetMapping("/listarTodoConPaginacion")
	public ResponseEntity<List<Compras>> listarTodoConPaginacion(@RequestParam(value="pageNo", defaultValue = "0" ,required=false) int pageNo,
			                                                        @RequestParam(value="noRegistro", defaultValue = "10" ,required=false) int noRegistro,
			                                                        @RequestParam(value="sortBy", defaultValue = "idCompras" ,required=false) String idCompras,
			                                                        @RequestParam(value="sortDir", defaultValue = "asc" ,required=false) String sortDir ){
		ResponseEntity<List<Compras>> response  =null;
		  
		try {
			response =  new ResponseEntity<>(comprasFacade.listarTodasLasComprasPorPaginacion(pageNo,noRegistro,idCompras,sortDir), HttpStatus.OK);                  
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return response; 
	}

	
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Response> guardarCompra(@RequestBody ComprasDTO comprasDTO){
		ResponseEntity<Response> response  =null;
		  
		try {
			response =  new ResponseEntity<>(comprasFacade.guardar(comprasDTO), HttpStatus.OK);                  
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return response; 
	}
	
	
	
	
	@PutMapping("/editar")
	public ResponseEntity<Response> editarCompra(@RequestBody ComprasDTO comprasDTO){
		ResponseEntity<Response> response  =null;
		  
		try {
			response =  new ResponseEntity<>(comprasFacade.editar(comprasDTO), HttpStatus.OK);  
			System.out.println(response);
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return response; 
	}
	
	
	

}
