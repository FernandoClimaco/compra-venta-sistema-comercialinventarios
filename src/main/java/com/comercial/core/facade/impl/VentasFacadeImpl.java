package com.comercial.core.facade.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comercial.core.facade.VentasFacade;
import com.comercial.core.mapper.VentasMapper;
import com.comercial.dto.VentasDTO;
import com.comercial.entidades.Ventas;
import com.comercial.response.Response;

@Component
public class VentasFacadeImpl implements VentasFacade {
	
	@Autowired
	private VentasMapper ventasMapper;
	

	@Override
	public List<Ventas> listarTodasLasVentas() {
		List<Ventas> lst = null;

		try {
			
			lst = ventasMapper.listarTodasLasVentas();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	@Override
	public List<Ventas> listarTodasLasVentasConPaginacion(int pageNo, int numeroRegistro, String busqueda, String sortDir) {
		List<Ventas> lst = null;

		try {
			
			 lst = ventasMapper.listarTodasLasVentasConPaginacion( pageNo,  numeroRegistro,  busqueda,  sortDir);
			  
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	
	@Override
	public Response guardarVenta(VentasDTO ventasDTO) {
		Response response = new Response();
		 
		try {
			
			response = ventasMapper.guardarVenta(ventasDTO);
			
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("DATOS GUARDADOS");
				System.out.println(response);
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("DATOS NO GUARDADOS");
				System.out.println(response);
			} 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

}
