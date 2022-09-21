package com.comercial.core.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service; 
import com.comercial.core.service.ClientesServices;
import com.comercial.entidades.Clientes; 
import com.comercial.repositorio.ClientesRepositorio;
import com.comercial.response.Response;

@Service
public class ClientesServicesImpl implements ClientesServices{
	
	@Autowired
	private ClientesRepositorio clientesRepositorio;

	@Override
	public List<Clientes> listarTodosLosClientes() {
		
		List<Clientes> listaClientes = null;

		try {
			listaClientes = clientesRepositorio.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return listaClientes;
	}
	
	
	
	
	@Override
	public List<Clientes> listarPorPaginacion(int pageNo, int cantidadRegistros, String sortBy, String sortDir) {
		List<Clientes> listaClientes = null;
		 
		try {
			
			Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
			Pageable pageable = PageRequest.of(pageNo, cantidadRegistros, sort );
			Page<Clientes> page = clientesRepositorio.findAll(pageable);
			
			listaClientes =  page.getContent();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		} 
		return listaClientes;
	}
	
	
	
	

	@Override
	public List<Clientes> buscarPorCodigoCliente(String codigoCliente) {
		
		List<Clientes> buscarPorCodigoCliente = null;
		try {
			
			buscarPorCodigoCliente =  clientesRepositorio.buscarPorCodigoCliente(codigoCliente);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return buscarPorCodigoCliente;
	}

	
	
	
	@Override
	public List<Clientes> buscarPorCodigoYDuiClientes(String codigoCliente, String dui) {
		List<Clientes> buscarPorCodigoCliente = null;
		try {
			
			buscarPorCodigoCliente =  clientesRepositorio.buscarPorCodigoYDuiClientes(codigoCliente, dui);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return buscarPorCodigoCliente;
	}

	
	
	
	@Override
	public Response guardarClientes(Clientes clientes) {
		Response response = new Response();
		try {
			
			Clientes cliente = clientesRepositorio.save(clientes);
			if(cliente!=null) {
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
			
			   
			List<Clientes> busqueda =  clientesRepositorio.buscarPorDuiCliente(clientes.getDui());
			
			if(busqueda!=null) {
				
				if(clientes.getFechaRegistro() != null && !clientes.getFechaRegistro().equals(" ") ) {
					busqueda.get(0).setFechaRegistro(clientes.getFechaRegistro());
				}
				
				if(clientes.getNombres()!=null && !clientes.getNombres().equalsIgnoreCase(" ") && !clientes.getNombres().isEmpty()) {
					busqueda.get(0).setNombres(clientes.getNombres());
				}
				
				if(clientes.getApellidos()!=null && !clientes.getApellidos().equalsIgnoreCase(" ") && !clientes.getApellidos().isEmpty()) {
					busqueda.get(0).setApellidos(clientes.getApellidos());
				}
				
				if(clientes.getDui()!=null && !clientes.getDui().equalsIgnoreCase(" ") && !clientes.getDui().isEmpty()) {
					busqueda.get(0).setDui(clientes.getDui());
				}
				
				if(clientes.getNit()!=null && !clientes.getNit().equalsIgnoreCase(" ") && !clientes.getNit().isEmpty()) {
					busqueda.get(0).setNit(clientes.getNit());
				}
				
				if(clientes.getTelefonos()!=null && !clientes.getTelefonos().equalsIgnoreCase(" ") && !clientes.getTelefonos().isEmpty()) {
					busqueda.get(0).setTelefonos(clientes.getTelefonos());
				}
				
				if(clientes.getDireccon()!=null && !clientes.getDireccon().equalsIgnoreCase(" ") && !clientes.getDireccon().isEmpty()) {
					busqueda.get(0).setDireccon(clientes.getDireccon());
				}
				
				if(clientes.getCorreoElectronico()!=null && !clientes.getCorreoElectronico().equalsIgnoreCase(" ") && !clientes.getCorreoElectronico().isEmpty()) {
					busqueda.get(0).setCorreoElectronico(clientes.getCorreoElectronico());
				}
				
				Clientes cliente = clientesRepositorio.save(busqueda.get(0));
				
				if(cliente!=null) {
					response.setIdTransaccion(UUID.randomUUID().toString());
					response.setMensaje("El cliente a sido guardado");
				}else {
					response.setIdTransaccion(UUID.randomUUID().toString());
					response.setMensaje("El cliente NO a sido guardado");
				}  
			}  
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return response;
	}

	
	
	
	
	@Override
	public Response eliminarClientes(String dui) {
		Response response =  new Response();
		
		try {
			
			List<Clientes> busqueda =  clientesRepositorio.buscarPorDuiCliente(dui);
			
			if(busqueda!=null) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("El cliente a sido eliminado");
				clientesRepositorio.delete(busqueda.get(0));
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
