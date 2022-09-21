package com.comercial.core.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comercial.core.service.ComprasServices;
import com.comercial.core.service.ProductosServices;
import com.comercial.entidades.Compras;
import com.comercial.entidades.Productos;
import com.comercial.repositorio.ComprasRepositorio;
import com.comercial.repositorio.ProductosRepositorio;
import com.comercial.response.Response;
 

@Service
public class ComprasServicesImpl implements ComprasServices {
	
	@Autowired
	private ComprasRepositorio comprasRepositorio;
	
	@Autowired
	private ProductosRepositorio productoRepositorio;
	
	@Autowired
	private ProductosServices productosServices;
	  

	
	
	@Override
	public List<Compras> listarTodasLasCompras() {
		List<Compras> lstCompras = null;
		try {
			lstCompras = comprasRepositorio.findAll();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lstCompras;
	}

	
	@Override
	public List<Compras> listarTodasLasComprasPorPaginacion(int pageNo, int numeroRegistros, String sortBy, String sorDir) {
		
		List<Compras> lstC = null;
		try {
			Sort sort = sorDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
			Pageable pageable = PageRequest.of(pageNo, numeroRegistros, sort);
			Page<Compras> lstCompras = comprasRepositorio.findAll(pageable);
			
			lstC = lstCompras.getContent();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
 		return lstC;
	}

	
	
	
	@Override
	public List<Compras> buscarPorNumeroSerieComprobante(String numeroSerieComprobante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compras> buscarPorCodigoProductoYNumeroSerieComprobante(String codigoProducto,
			String numeroSerieComprobante) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	@Override
	public Response guardar(Compras compras) {
		Response response = new Response();
		   Compras comp = new Compras();
		   Productos productos = new Productos();
		   List<Productos> listaPr = null;
		   
		   try {
				
				//Modificando el stock
				listaPr = productoRepositorio.busquedaPorCodigoProducto(compras.getIdProductos().getCodigoProducto()    );
				
				if(!listaPr.isEmpty() ) {
					 
					if(compras.getIdProductos().getStock() > 0 ) {
						 int stock = 0;
						 stock = listaPr.get(0).getStock() + compras.getIdProductos().getStock();
						 listaPr.get(0).setStock( stock ); 
					}
					
					//editar el registro de productos con stock actualizado
					productosServices.guardar(listaPr.get(0));
					
					System.out.println(compras);
					 //Guardando las compras: 
					 comp = comprasRepositorio.save(compras);  
						
					 if(comp != null) { 
						 response.setIdTransaccion(UUID.randomUUID().toString());
						 response.setMensaje("compras guardadas");
						 System.out.println(response);
						 
					 }else { 
						 response.setIdTransaccion(UUID.randomUUID().toString());
						 response.setMensaje("compras no  guardadas");
						 System.out.println(response);
					 } 
				}
			}catch(Exception e) {
				System.out.println(e.getMessage().toString());
			}
		   return response; 
	}

	
	
	
	
	@Override
	public Response editar(Compras compras) {
		
		List<Compras> lstCompras = null;
		Response response = new Response();


		try {
			 
			lstCompras = comprasRepositorio.buscarPorNumeroSerieComprobante(compras.getNumeroSerieComprobante());
			
			if(!lstCompras.isEmpty()) {
				
				  
				
				if(compras.getIdProductos().getIdProducto()>0) {
					lstCompras.get(0).getIdProductos().setIdProducto(compras.getIdProductos().getIdProducto());
				}
				
				if(compras.getIdEmpleados().getIdEmpleado()>0) {
					lstCompras.get(0).getIdEmpleados().setIdEmpleado(compras.getIdEmpleados().getIdEmpleado());
				}
				 
				Compras lstComprasEditadas = comprasRepositorio.save(lstCompras.get(0));
				
				if(lstComprasEditadas!=null) {
					response.setIdTransaccion(UUID.randomUUID().toString());
					response.setMensaje("Datos editados");
					System.out.println(response);

				}else {
					response.setIdTransaccion(UUID.randomUUID().toString());
					response.setMensaje("Datos no editados");
					System.out.println(response);

				} 
			} else {
				System.out.println("Capa services , datos no encontrados por lo tanto no se procede a editar");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return response;
	}

	
	
	
	
	@Override
	public Response eliminar(Compras compras) {
		// TODO Auto-generated method stub
		return null;
	}

}
