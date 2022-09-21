package com.comercial.core.facade;

import java.util.List; 
import com.comercial.dto.ProductosDTO;
import com.comercial.entidades.Productos;
import com.comercial.response.Response;

public interface ProductoFacade {

	//************  AQUI SOLAMENTE ME HACE FALTA PRACTICAS CON QUERYS BASICAS Y CON QUERY AVANZADA **************
	public List<Productos> listarTodosLosProductos();
	public List<Productos> listarPorCodigoProductos(String codigoProducto); 
	public List<Productos> buscarProductoCodigoStock(String codigoProducto, int stock);
	public List<Productos> listarTodoConPaginacion(int pageNo,int cantidadRegistro,String ordenarPor,String sortDir );
	
	public Response guardarProducto(ProductosDTO productoDTO);
	public Response editarProducto(ProductosDTO productoDTO); 
	public Response eliminarProductoCodigo(String codigoProducto);
	
}
