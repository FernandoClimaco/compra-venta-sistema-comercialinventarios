package com.comercial.core.mapper.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.comercial.core.mapper.ClientesMapper;
import com.comercial.core.service.ClientesServices;
import com.comercial.entidades.Clientes;
import com.comercial.response.Response;


@Component
public class ClientesMapperImpl implements ClientesMapper{
	
	@Autowired
	private ClientesServices clientesServices;

	
	
	@Override
	public List<Clientes> listarTodosLosClientes() {
		List<Clientes> listaClientes = null;

		try {
			listaClientes = clientesServices.listarTodosLosClientes();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return listaClientes;
	}
	
	
	

	@Override
	public List<Clientes> listarPorPaginacion(int pageNo, int cantidadRegistros, String sortBy, String sortDir) {
		List<Clientes> listaClientes = null;
		 
		try {
			 
			listaClientes = clientesServices.listarPorPaginacion(pageNo, cantidadRegistros, sortBy, sortDir);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return listaClientes;
	}

	
	
	
	
	
	@Override
	public List<Clientes> buscarPorCodigoCliente(String codigoCliente) {
		List<Clientes> buscarPorCodigoCliente = null;
		try {
			
			buscarPorCodigoCliente =  clientesServices.buscarPorCodigoCliente(codigoCliente);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return buscarPorCodigoCliente;
	}

	
	
	@Override
	public List<Clientes> buscarPorCodigoYDuiClientes(String codigoCliente, String dui) {
		List<Clientes> buscarPorCodigoCliente = null;
		try {
			
			buscarPorCodigoCliente =  clientesServices.buscarPorCodigoYDuiClientes(codigoCliente, dui);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return buscarPorCodigoCliente;
	}

	
	
	
	
	@Override
	public Response guardarClientes(Clientes clientes) {
		Response response = new Response();
		try {
			
			 response = clientesServices.guardarClientes(clientes);
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente a sido guardado");
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente NO a sido guardado");
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return response;
	}

	
	
	
	
	@Override
	public Response editarClientes(Clientes clientes) {
		Response response = new Response();
		try {
			
			 response = clientesServices.editarClientes(clientes);
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente a sido guardado");
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente NO a sido guardado");
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return response;
	}

	
	
	
	@Override
	public Response eliminarClientes(String codigoCliente) {
      Response response =  new Response();
		
		try {
			
			response =  clientesServices.eliminarClientes(codigoCliente);
			
			if(response!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente a sido eliminado"); 
			}else {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente no a sido eliminado");
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return response;
	}

}
