package com.comercial.core.facade;

import java.util.List;

import com.comercial.dto.ComprasDTO;
import com.comercial.entidades.Compras;
import com.comercial.response.Response;

public interface ComprasFacade {
	
	public List<ComprasDTO> listarTodasLasCompras();
	public List<Compras> mostrarListCompras();
	public List<Compras> listarTodasLasComprasPorPaginacion(int pageNo, int numeroRegistros, String sortBy, String sorDir);
	public List<ComprasDTO> buscarPorNumeroSerieComprobante(String numeroSerieComprobante);
	public List<ComprasDTO> buscarPorCodigoProductoYNumeroSerieComprobante(String codigoProducto, String numeroSerieComprobante);
	
	public Response guardar(ComprasDTO comprasDTO);
	public Response editar(ComprasDTO comprasDTO);
	public Response eliminar(ComprasDTO comprasDTO);
	

}
