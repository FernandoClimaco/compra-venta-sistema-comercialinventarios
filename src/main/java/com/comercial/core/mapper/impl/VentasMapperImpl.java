package com.comercial.core.mapper.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.comercial.core.mapper.VentasMapper;
import com.comercial.core.service.VentasServices;
import com.comercial.dto.VentasDTO;
import com.comercial.entidades.Empleados;
import com.comercial.entidades.Productos;
import com.comercial.entidades.TipoComprobante;
import com.comercial.entidades.Ventas;
import com.comercial.response.Response;


@Component
public class VentasMapperImpl implements VentasMapper{
	
	@Autowired
	private VentasServices ventasServices;
	

	@Override
	public List<Ventas> listarTodasLasVentas() {
		List<Ventas> lst = null;

		try {
			
			lst = ventasServices.listarTodasLasVentas();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	@Override
	public List<Ventas> listarTodasLasVentasConPaginacion(int pageNo, int numeroRegistro, String busqueda, String sortDir) {
		List<Ventas> lst = null;

		try {
			
			 lst = ventasServices.listarTodasLasVentasConPaginacion( pageNo,  numeroRegistro,  busqueda,  sortDir);
			  
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	@Override
	public Response guardarVenta(VentasDTO ventasDTO) {
		Response response = new Response();
		Ventas ventas = new Ventas();
		 
		try {
			
			ventas = this.mapearEntidadVentas(ventasDTO);
			response = ventasServices.guardarVenta(ventas);
			
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
	
	
	
	
	public Ventas mapearEntidadVentas(VentasDTO ventasDTO) {
		
		Ventas ventas = new Ventas();
		
		try {
			
			ventas.setIdVentas(ventasDTO.getIdVentas());
			ventas.setFechaVenta(new Date());
			ventas.setTipoComprobante(TipoComprobante.comprobanteCreditoFiscal);
			ventas.setNumeroSerieComprobante(ventasDTO.getNumeroSerieComprobante());
			
			
			Productos productos = new Productos();
			productos.setIdProducto(ventasDTO.getIdProducto());
			productos.setFechaRegistro(new Date());
			productos.setCodigoProducto(ventasDTO.getCodigoProducto());
			productos.setNombreProducto(ventasDTO.getNombreProducto());
			productos.setStock(ventasDTO.getStock());
			productos.setPrecioUnitario(ventasDTO.getPrecioUnitario()); 
			ventas.setProductos(productos);
			
			Empleados empleados = new Empleados();
			empleados.setIdEmpleado(ventasDTO.getIdVentas());
			ventas.setIdEmpleados(empleados);
			
		}catch(Exception e) {
			System.out.println("metodo mapear entidad ventas, error: " + e.getMessage());
		} 
		return ventas;
	}
	
	

}
