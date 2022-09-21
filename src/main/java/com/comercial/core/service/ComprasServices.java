package com.comercial.core.service;

import java.util.List;

import com.comercial.entidades.Compras;
import com.comercial.response.Response;

public interface ComprasServices {
	
	
	public List<Compras> listarTodasLasCompras();
	public List<Compras> listarTodasLasComprasPorPaginacion(int pageNo, int numeroRegistros, String sortBy, String sorDir);
	public List<Compras> buscarPorNumeroSerieComprobante(String numeroSerieComprobante);
	public List<Compras> buscarPorCodigoProductoYNumeroSerieComprobante(String codigoProducto, String numeroSerieComprobante);
	
	public Response guardar(Compras compras);
	public Response editar(Compras compras);
	public Response eliminar(Compras compras);

}
