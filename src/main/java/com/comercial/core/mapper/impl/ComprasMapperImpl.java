package com.comercial.core.mapper.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import com.comercial.core.mapper.ComprasMapper; 
import com.comercial.core.service.ComprasServices; 
import com.comercial.dto.ComprasDTO;
import com.comercial.entidades.Compras;
import com.comercial.entidades.Empleados;
import com.comercial.entidades.Productos;
import com.comercial.entidades.TipoComprobante;
import com.comercial.repositorio.EmpleadosRepositorio;
import com.comercial.response.Response;

@Component
public class ComprasMapperImpl implements ComprasMapper{
	
	
	@Autowired
	private ComprasServices comprasServices;
	
	@Autowired
	private EmpleadosRepositorio empleadosRepositorio;
	 
	
	

	@Override
	public List<ComprasDTO> listarTodasLasCompras() {
		List<ComprasDTO> lstComprasDTO = null;
		try {
			
			List<Compras> listarTodasLasCompras = comprasServices.listarTodasLasCompras(); 
			 lstComprasDTO = mapearComprasDTO(listarTodasLasCompras);
			  	 	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lstComprasDTO;
	}
	
	
	@Override
	public List<Compras> mostrarListCompras() {
		List<Compras> lstCompras = null;
		try {
			
			  lstCompras = comprasServices.listarTodasLasCompras();
			 		 	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lstCompras;
	}

	
	
	
	
	@Override
	public List<Compras> listarTodasLasComprasPorPaginacion(int pageNo, int numeroRegistros, String sortBy, String sorDir) {
		 
		List<Compras> lst = null;
		try {
			
			lst = comprasServices.listarTodasLasComprasPorPaginacion(pageNo, numeroRegistros, sortBy, sorDir);
			  
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

			Compras mapearCompras = mapearEntidad(comprasDTO);
			response = comprasServices.guardar(mapearCompras);

			if (response != null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("compras guardadas");
			} else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("compras no guardadas");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			response.setIdTransaccion(UUID.randomUUID().toString());
			response.setMensaje("compras no guardadas");
		}
		return response;
	}

	
	
	
	
	
	
	@Override
	public Response editar(ComprasDTO comprasDTO) {
		Response response = new Response();
		Compras compras = new Compras();

		try {
			compras = this.mapearEntidad(comprasDTO);
			response  = comprasServices.editar(compras);
			
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

	
	
	
	// mapeo ComprasDTO hacia entidad: Compras
	public Compras mapearEntidad(ComprasDTO comprasDTO) {
		Compras compras = new Compras();
		 
		
		try {
			
			 compras.setIdCompras(comprasDTO.getIdCompras()); 
			 compras.setFechaCompras(new Date()); 
			 compras.setTipoComprobante(TipoComprobante.ticket);
			 compras.setNumeroSerieComprobante(comprasDTO.getNumeroSerieComprobante());
			  
			 Productos productos = new Productos();
			 productos.setIdProducto(comprasDTO.getIdProducto());
			 
			 
			 productos.setFechaRegistro( new Date()  ); 
			 productos.setCodigoProducto(comprasDTO.getCodigoProducto());
			 productos.setNombreProducto(comprasDTO.getNombreProducto());
			 productos.setStock( comprasDTO.getStock()  );
			 productos.setPrecioUnitario(comprasDTO.getPrecioUnitario()); 
			 compras.setIdProductos( productos  ); 
			 
			 
			 //buscar empleados por> codigoEmpleado
			 List<Empleados> lstEmpleados = new ArrayList<>();
			 Empleados empleados = new Empleados();
			 lstEmpleados = empleadosRepositorio.buscarPorCodigoEmpleados(comprasDTO.getCodigoEmpleado()); 
			 
			 compras.setIdEmpleados( lstEmpleados.get(0));
			 
		}catch(Exception e) { 
			System.out.println( e.getMessage().toString()   );
		} 
		return compras;
	}
	
	
	
	
	public List<ComprasDTO> mapearComprasDTO(List<Compras> compras){
		List<ComprasDTO> lst = new ArrayList<>();
		ComprasDTO comprasDTO = new ComprasDTO();
		
		try {
			
			comprasDTO.setIdCompras(compras.get(0).getIdCompras());
			comprasDTO.setFechaCompras(compras.get(0).getFechaCompras().toString());
			comprasDTO.setTipoComprobante(compras.get(0).getTipoComprobante().toString());
			comprasDTO.setNumeroSerieComprobante(compras.get(0).getNumeroSerieComprobante());
			comprasDTO.setIdProducto(compras.get(0).getIdProductos().getIdProducto());
			comprasDTO.setFechaRegistro(compras.get(0).getIdProductos().getFechaRegistro().toString());
			comprasDTO.setCodigoProducto(compras.get(0).getIdProductos().getCodigoProducto());
			comprasDTO.setNombreProducto(compras.get(0).getIdProductos().getNombreProducto());
			comprasDTO.setStock(compras.get(0).getIdProductos().getStock());
			comprasDTO.setPrecioUnitario(compras.get(0).getIdProductos().getPrecioUnitario()); 
			
			lst.add(comprasDTO);
			 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lst;
	}
	
	
	
	
	 

}
