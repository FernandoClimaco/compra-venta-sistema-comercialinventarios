package com.comercial.core.mapper;

import java.util.List;

import com.comercial.dto.ProductosDTO;
import com.comercial.entidades.Productos;
import com.comercial.response.Response;

public interface ProductoMapper {
	
	//************  AQUI SOLAMENTE ME HACE FALTA PRACTICAS CON QUERYS BASICAS Y CON QUERY AVANZADA **************
		public List<Productos> listarTodosLosProductos();
		public List<Productos> listarPorCodigoProductos(String codigoProducto); 
		public List<Productos> buscarProductoCodigoStock(String codigoProducto, int stock);
		public List<Productos> listarTodoConPaginacion(int pageNo, int cantidadRegistro,String orderPor,String sortDir);
		
		public Response guardarProducto(ProductosDTO productoDTO);
		public Response editarProducto(ProductosDTO productoDTO); 
		public Response eliminarProductoCodigo(String codigoProducto);

}
