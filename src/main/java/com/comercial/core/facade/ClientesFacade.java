package com.comercial.core.facade;

import java.util.List;

import com.comercial.entidades.Clientes;
import com.comercial.response.Response;

public interface ClientesFacade {
	
	public List<Clientes> listarTodosLosClientes();
	public List<Clientes> listarPorPaginacion(int pageNo, int cantidadRegistros, String sortBy, String sortDir);
	public List<Clientes> buscarPorCodigoCliente(String codigoCliente);
	public List<Clientes> buscarPorCodigoYDuiClientes(String codigoCliente, String dui);
	
	public Response guardarClientes(Clientes clientes);
	public Response editarClientes(Clientes clientes);
	public Response eliminarClientes(String codigoCliente);

}
