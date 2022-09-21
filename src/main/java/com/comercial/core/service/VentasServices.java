package com.comercial.core.service;

import java.util.List;

import com.comercial.entidades.Ventas;
import com.comercial.response.Response;

public interface VentasServices {
	
	public List<Ventas> listarTodasLasVentas();
	public List<Ventas> listarTodasLasVentasConPaginacion(int pageNo, int numeroRegistro, String busqueda, String sortDir);
	public Response guardarVenta(Ventas ventas);
	

}
