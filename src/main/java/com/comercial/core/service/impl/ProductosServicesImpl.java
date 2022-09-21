package com.comercial.core.service.impl;

 
import java.util.List;
import java.util.UUID; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service; 
import com.comercial.core.service.ProductosServices;
import com.comercial.entidades.Productos;
import com.comercial.repositorio.ProductosRepositorio;
import com.comercial.response.Response;
import com.comercial.utils.excepcion.CustomException; 

@Service
public class ProductosServicesImpl implements ProductosServices{
	
	@Autowired
	private ProductosRepositorio productosRepository;
	
	
	@Override
	public List<Productos> listarTodosLosProductos() {

		List<Productos> listaProductos = null;
		try { 
			listaProductos = productosRepository.findAll(); 
		} catch (Exception e) {
			e.getMessage();
		}
		return listaProductos;
	}
	
	
	
	
	@Override
	public List<Productos> listarPorCodigoProductos(String codigoProductos) {
		List<Productos> listaProductos = null;
		try { 
			listaProductos = productosRepository.busquedaPorCodigoProducto(codigoProductos);
			
			if(listaProductos.isEmpty()) {
				throw new CustomException("Lista productos :" + listaProductos,"Datos no encontrados", 404);
			}
			
		} catch (CustomException c) {
			throw c;
		}catch (Exception e) {
			e.getMessage();
		}
		return listaProductos;
	}
	
	
	
	
	@Override
	public List<Productos> listarTodoConPaginacion(int pageNo, int cantidadRegistro,String ordenarPor,String sortDir){
		List<Productos> listaProductos = null;
		try { 
			
			 Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending() : Sort.by(ordenarPor).descending();
			 Pageable pageable = PageRequest.of(pageNo, cantidadRegistro, sort );
			
			 Page<Productos> pageProductos = productosRepository.findAll(pageable);
			
			
			listaProductos = pageProductos.getContent();
			
			if(listaProductos.isEmpty()) {
				throw new CustomException("Lista productos :" + listaProductos,"Datos no encontrados", 404);
			}
			
		} catch (CustomException c) {
			throw c;
		}catch (Exception e) {
			System.out.println( e.getMessage()   );		}
		return listaProductos;
	}
	
	
	
	
	@Override
	public List<Productos> buscarProductoCodigoStock(String codigoProductos, int stock) {
		List<Productos> listaProductos = null;
		try { 
			listaProductos = productosRepository.findByProductos(codigoProductos, stock);
		} catch (Exception e) {
			e.getMessage();
		}
		return listaProductos;
	}

	
	
	

	@Override
	public Productos guardar(Productos productos) {
		Productos response = new Productos();

		try {

			response = productosRepository.save(productos);

		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}




	@Override
	public Response eliminar(String codigoProducto) {
		Response response = new Response();
		try {
			List<Productos> producto = productosRepository.busquedaPorCodigoProducto(codigoProducto);
			
			for (Productos productos : producto) {
				  productosRepository.delete(  productos  ); 
			}
			
			response.setIdTransaccion(UUID.randomUUID().toString());
			response.setMensaje("Registros eliminados");
			
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}



 

}
