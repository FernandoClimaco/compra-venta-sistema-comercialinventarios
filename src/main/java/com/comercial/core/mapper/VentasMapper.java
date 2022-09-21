package com.comercial.core.mapper;

import java.util.List;

import com.comercial.dto.VentasDTO;
import com.comercial.entidades.Ventas;
import com.comercial.response.Response;

public interface VentasMapper {
	
	public List<Ventas> listarTodasLasVentas();
	public List<Ventas> listarTodasLasVentasConPaginacion(int pageNo, int numeroRegistro, String busqueda, String sortDir);
	public Response guardarVenta(VentasDTO ventasDTO);

}
