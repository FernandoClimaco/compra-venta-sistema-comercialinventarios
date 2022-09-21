package com.comercial.core.service;

import java.util.List;

import com.comercial.entidades.Productos;
import com.comercial.response.Response; 

public interface ProductosServices {
	
	public List<Productos> listarTodosLosProductos();
	public List<Productos> listarPorCodigoProductos(String codigoProductos);
	public List<Productos> buscarProductoCodigoStock(String codigoProductos, int stock);
	public List<Productos> listarTodoConPaginacion(int pageNo, int medidaDePagina,String ordernarPor,String sortDir);
	
	public Productos guardar(Productos productos);
	public Response eliminar(String codigoPoroducto);

}
