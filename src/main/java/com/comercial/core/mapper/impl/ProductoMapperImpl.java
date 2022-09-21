package com.comercial.core.mapper.impl;

import java.util.List;
import java.util.UUID; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.comercial.core.mapper.ProductoMapper;
import com.comercial.core.service.ProductosServices;
import com.comercial.dto.ProductosDTO;
import com.comercial.entidades.Productos; 
import com.comercial.response.Response;
import com.comercial.utils.excepcion.CustomException;

@Component
public class ProductoMapperImpl implements ProductoMapper {

	
	@Autowired
	private ProductosServices productosServices;
	
	
	@Override
	public List<Productos> listarTodosLosProductos() {
		
		List<Productos> listaProductos = null;

            try {
            	listaProductos =  productosServices.listarTodosLosProductos();
             
    		}catch(Exception e){
    			e.getMessage();
    		}  
		return listaProductos;
	}
	
	
	
	
	@Override
	public List<Productos> listarTodoConPaginacion(int pageNo, int cantidadRegistro,String ordenarPor,String sortDir) {
		Response response = new Response();
		List<Productos> listaProductos = null;
		try {

			listaProductos = productosServices.listarTodoConPaginacion(pageNo, cantidadRegistro, ordenarPor,sortDir);

			if (listaProductos.isEmpty()) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("REGISTROS No encontrados!!!");
				System.out.println(response);
				//throw new CustomException("404","Datos no encontrados");
			}
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
				System.out.println(response);
			} else if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);

			} else if (e.getRawStatusCode() == 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
				System.out.println(response); 
			}
		}catch (CustomException c) {
			throw c;
		}catch(Exception e) {
			System.out.println( e.getMessage()   );
		}
		
		return listaProductos;
	}
	

	


	@Override
	public List<Productos> listarPorCodigoProductos(String codigoProducto) {
		List<Productos> listaProductos = null;

        try {
        	listaProductos =  productosServices.listarPorCodigoProductos(codigoProducto);
        	
        	//if(listaProductos.isEmpty()) {
			//	throw new CustomException("404","Datos no encontrados");
			//}
         
		}catch (CustomException c) {
			throw c;
		}catch(Exception e){
			e.getMessage();
		}  
	return listaProductos;
	}



	@Override
	public List<Productos> buscarProductoCodigoStock(String codigoProducto, int stock) {
		
		Response response = new Response();
		List<Productos> p = null;
		try {
			
			 p =productosServices.buscarProductoCodigoStock(codigoProducto, stock);
			
			if(p!=null) {
				System.out.println(p);
			} 
			
		}catch(HttpClientErrorException e){ 
			
			if( e.getRawStatusCode() == 404 ) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado: " + e.getMessage());
			}
			else if( e.getRawStatusCode() == 500 ) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno: " + e.getMessage());
			} 
		}catch(Exception e){
			e.getMessage();
		} 
		 
		return p;
	}
	 
	
	
	
	
	
	@Override
	public Response guardarProducto(ProductosDTO productosDTO) {
		Response response = new Response();
		 
		try { 
			//Convertir DTO a Entity:
			Productos productos = this.mapearEntidadProductos(productosDTO);
			
			Productos produtosGuardados = productosServices.guardar(productos);
			
              if(produtosGuardados== null) {
            	  response.setIdTransaccion(UUID.randomUUID().toString());
            	  response.setMensaje("Productos no guardados");
              }else {
            	  response.setIdTransaccion(UUID.randomUUID().toString());
            	  response.setMensaje("Productos guardados"); 
              }
			 
		}catch(HttpClientErrorException e){ 
			System.out.println(e.getRawStatusCode());
			if( e.getRawStatusCode() == 404 ) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado: " + e.getMessage());
			}
			else if( e.getRawStatusCode() == 500 ) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno: " + e.getMessage());
			} 
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.getMessage();
		} 
		return response;
	}
	
	
	 


	@Override
	public Response editarProducto(ProductosDTO productoDTO) {
		
		Response response = new Response();


		// consultando en la base de datos el registro:
		List<Productos> productos = productosServices.listarPorCodigoProductos(productoDTO.getCodigoProducto());
		 
		
		if(productos.isEmpty()) {
			//Excepcion personalizada
			System.out.println("Registros no encontrados,por lo tanto no se editaron los datos");
		}else {
			 
			if( productoDTO.getNombreProducto() != null && !productoDTO.getNombreProducto().equalsIgnoreCase(" ") && !productoDTO.getNombreProducto().isEmpty() ) {
				productos.get(0).setNombreProducto(productoDTO.getNombreProducto());
 			}
			
		    if(  !(productoDTO.getStock() == productos.get(0).getStock()) ) {
				productos.get(0).setStock(productoDTO.getStock());
			}
			 
			Productos produtosActualizados = productosServices.guardar(productos.get(0) 	);
			
			 if(produtosActualizados == null) {
           	  response.setIdTransaccion(UUID.randomUUID().toString());
           	  response.setMensaje("Productos no actualizados");
             }else {
           	  response.setIdTransaccion(UUID.randomUUID().toString());
           	  response.setMensaje("Productos actualizados"); 
             } 
		} 
		return response;
	}



	@Override
	public Response eliminarProductoCodigo(String codigoProducto) {
		
		Response response = new Response();
		
        try {
        	 
			    response =  productosServices.eliminar(codigoProducto); 
			 
		}catch(Exception e) {
			e.getMessage();
		}  
		return response;
	}
	
	
	
	
	public Productos mapearEntidadProductos(ProductosDTO productosDTO) { 
		Productos productos = new Productos();
		
		try {
			
			productos.setIdProducto(productosDTO.getIdProducto() /*!= productosDTO.getIdProducto() ? productosDTO.getIdProducto() : null*/ );
			productos.setFechaRegistro(productosDTO.getFechaRegistro() /*!= productosDTO.getFechaRegistro() ? productosDTO.getFechaRegistro() : null*/);
			productos.setCodigoProducto(productosDTO.getCodigoProducto() /*!= productosDTO.getCodigoProducto() ? productosDTO.getCodigoProducto() : null*/);
			productos.setNombreProducto(productosDTO.getNombreProducto() /*!= productosDTO.getNombreProducto() ? productosDTO.getNombreProducto() : null*/);
			productos.setStock(productosDTO.getStock() /* != productosDTO.getStock() ? productosDTO.getStock() : null*/);
			productos.setPrecioUnitario(productosDTO.getPrecioUnitario() /*!= productosDTO.getPrecioUnitario() ? productosDTO.getPrecioUnitario() : null*/);
			 
		}catch(Exception e) {
			e.getMessage();
		}
		
		 return productos; 
	}
	
	
	
	

}
