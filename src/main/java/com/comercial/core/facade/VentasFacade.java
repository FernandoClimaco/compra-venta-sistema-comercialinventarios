package com.comercial.core.facade;

import java.util.List; 
import com.comercial.dto.VentasDTO;
import com.comercial.entidades.Ventas;
import com.comercial.response.Response;

public interface VentasFacade {
	
	
	public List<Ventas> listarTodasLasVentas();
	public List<Ventas> listarTodasLasVentasConPaginacion(int pageNo, int numeroRegistro, String busqueda, String sortDir);
	public Response guardarVenta(VentasDTO ventasDTO);

}
