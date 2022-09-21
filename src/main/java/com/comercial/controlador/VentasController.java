package com.comercial.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.core.facade.VentasFacade;
import com.comercial.dto.VentasDTO;
import com.comercial.entidades.Ventas;
import com.comercial.response.Response;

@RestController
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	private VentasFacade ventasFacade;
	
	
	@GetMapping("/mostrarVenta")
	public ResponseEntity<List<Ventas>> lstVentas() {
		ResponseEntity<List<Ventas>> lstVentas = null;

		try {

			lstVentas = new ResponseEntity<>(ventasFacade.listarTodasLasVentas(), HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return lstVentas;
	}
	
	
	
	@GetMapping("/mostrarVentaConPaginacion")
	public ResponseEntity<List<Ventas>> lstVentasConPaginacion(@RequestParam(value="pageNo", defaultValue="0", required = false) int pageNo,
			                               @RequestParam(value="numeroRegistro" , defaultValue = "10", required = false) int numeroRegistro,
			                               @RequestParam(value="ordenarPor" , defaultValue = "idVentas", required = false) String idVentas,
			                               @RequestParam(value="sortDir" , defaultValue = "asc", required = false) String sortDir
			) {
		ResponseEntity<List<Ventas>> lstVentas = null;

		try {

			lstVentas = new ResponseEntity<>(ventasFacade.listarTodasLasVentasConPaginacion(pageNo, numeroRegistro, idVentas, sortDir)  , HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return lstVentas;
	}
	
	
	
	
	@PostMapping("/guardarVenta")
	public ResponseEntity<Response> guardarVenta(@RequestBody VentasDTO ventasDTO) {
		ResponseEntity<Response> response = null;

		try {

			response = new ResponseEntity<>(ventasFacade.guardarVenta(ventasDTO), HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return response;
	}
	
	
	
	
	

}
