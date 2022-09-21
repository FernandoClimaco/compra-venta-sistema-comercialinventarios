package com.comercial.core.facade.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.comercial.core.facade.ComprasFacade;
import com.comercial.core.mapper.ComprasMapper;
import com.comercial.dto.ComprasDTO;
import com.comercial.entidades.Compras;
import com.comercial.response.Response;


@Component
public class ComprasFacadeImpl  implements ComprasFacade {
	
	@Autowired
	private ComprasMapper comprasMapper;
	

	@Override
	public List<ComprasDTO> listarTodasLasCompras() {
		List<ComprasDTO> listarTodasLasCompras = null;
		try {
			listarTodasLasCompras = comprasMapper.listarTodasLasCompras();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listarTodasLasCompras;
	}

	
	
	public List<Compras> mostrarListCompras() {
		List<Compras> listarTodasLasCompras = null;
		try {
			listarTodasLasCompras = comprasMapper.mostrarListCompras();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return listarTodasLasCompras;
	}
	
	
	
	@Override
	public List<Compras> listarTodasLasComprasPorPaginacion(int pageNo, int numeroRegistros, String sortBy, String sorDir) {
		List<Compras> lst = null;
		try {
			
			lst = comprasMapper.listarTodasLasComprasPorPaginacion(pageNo, numeroRegistros, sortBy, sorDir);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	@Override
	public List<ComprasDTO> buscarPorNumeroSerieComprobante(String numeroSerieComprobante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComprasDTO> buscarPorCodigoProductoYNumeroSerieComprobante(String codigoProducto,
			String numeroSerieComprobante) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	@Override
	public Response guardar(ComprasDTO comprasDTO) {
		 
		Response response = new Response();
		
		try {
			response =  comprasMapper.guardar(comprasDTO);                  
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());
		}
		 
		return response; 
	}
	
	
	
	

	@Override
	public Response editar(ComprasDTO comprasDTO) {
		
		Response response = new Response();

		try {
			
			response  = comprasMapper.editar(comprasDTO);
			if(response == null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Compras no editadas");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Compras editadas");
				System.out.println(response);

			} 
		}catch(Exception e) {
		  System.out.println(e.getMessage()); 
		} 
		return response;
	}
	
	

	@Override
	public Response eliminar(ComprasDTO comprasDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
