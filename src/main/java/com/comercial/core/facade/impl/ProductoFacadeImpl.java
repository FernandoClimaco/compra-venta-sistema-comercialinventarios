package com.comercial.core.facade.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException; 
import com.comercial.core.facade.ProductoFacade;
import com.comercial.core.mapper.ProductoMapper;
import com.comercial.dto.ProductosDTO;
import com.comercial.entidades.Productos;
import com.comercial.response.Response;
import com.comercial.utils.excepcion.CustomException;

@Component
public class ProductoFacadeImpl implements ProductoFacade {
	
	@Autowired
	private ProductoMapper productoMapper;
	
	
	
	@Override
	public List<Productos> listarTodosLosProductos() {
		Response response = new Response();
		List<Productos> listaProductos = null;

		try {

			listaProductos = productoMapper.listarTodosLosProductos();

			if (listaProductos.isEmpty()) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("REGISTROS No encontrados!!!");
				System.out.println(response);
				
			}
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
				System.out.println(response);
			} else if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);

			} else if (e.getRawStatusCode() == 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
				System.out.println(response);

			}
		}catch(Exception e) {
			e.getMessage();
		}
		return listaProductos;
	}


	
	
	
	@Override
	public List<Productos> listarTodoConPaginacion(int pageNo, int cantidadRegistro,String ordenarPor,String sortDir) {
		Response response = new Response();
		List<Productos> listaProductos = null;
		
		try {

			listaProductos = productoMapper.listarTodoConPaginacion(pageNo, cantidadRegistro, ordenarPor,sortDir);

			if (listaProductos.isEmpty()) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("REGISTROS No encontrados!!!");
				System.out.println(response);
				//throw new CustomException("404","Datos no encontrados");
			}
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
				System.out.println(response);
			} else if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);

			} else if (e.getRawStatusCode() == 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
				System.out.println(response);

			}
		}catch (CustomException c) {
			throw c;
		}catch(Exception e) {
			 
			System.out.println( e.getMessage()   );
		}
		
		return listaProductos;
	}

	
	
	
	
	@Override
	public List<Productos> listarPorCodigoProductos(String codigoProducto) {
		Response response = new Response();
		List<Productos> listaProductos = null;
		try {

			listaProductos = productoMapper.listarPorCodigoProductos(codigoProducto);

			if (listaProductos.isEmpty()) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("REGISTROS No encontrados!!!");
				System.out.println(response);
				//throw new CustomException("404","Datos no encontrados");
			}
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
				System.out.println(response);
			} else if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);

			} else if (e.getRawStatusCode() == 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
				System.out.println(response);

			}
		}catch (CustomException c) {
			throw c;
		}catch(Exception e) {
			e.getMessage();
		}
		return listaProductos;
	}


	
	
	
	@Override
	public List<Productos> buscarProductoCodigoStock(String codigoProducto, int stock) {
		Response response = new Response();
		List<Productos> listaProductos = null;
		try{
			
			listaProductos = productoMapper.buscarProductoCodigoStock(codigoProducto, stock);
			
		}catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
				System.out.println(response);
			} else if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
				System.out.println(response);

			} else if (e.getRawStatusCode() == 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
				System.out.println(response);

			}
		}catch(Exception e) {
			e.getMessage();
		}
		return listaProductos;
	}
	
	
	
	

	@Override
	public Response guardarProducto(ProductosDTO productoDTO) {
		
		Response response = new Response();
		
		try {
			
			if(Objects.nonNull(productoDTO.getCodigoProducto()) ) {
				// validar si la cadena es numero:
				String codigoProducto = productoDTO.getCodigoProducto();
				 boolean isNumeric =  codigoProducto.matches("[+-]?\\d*(\\.\\d+)?");
				 
				 if(isNumeric==false) {
					 //Excepcion personalizada: debe ser una cadena numerica
				 }
				 
			}
			else if( Objects.isNull(productoDTO.getNombreProducto())  ) {
				//Excepcion personalizada
			}
			
			
			
			//AGREGAR VALIDACIONES Y MANDAR EXCEPCIONES PERSONALIZADAS. 
			response = productoMapper.guardarProducto(productoDTO);	 
			
			 if(response == null) {
           	  response.setIdTransaccion(UUID.randomUUID().toString());
           	  response.setMensaje("Productos no guardados");
             }else {
           	  response.setIdTransaccion(UUID.randomUUID().toString());
           	  response.setMensaje("Productos guardados"); 
             }
			
		} catch (HttpClientErrorException e) { 
			
			if(e.getRawStatusCode()== 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
			}
			else if(e.getRawStatusCode()== 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
			}
			else if(e.getRawStatusCode()== 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
			}

		} catch (Exception e) {
			e.getMessage().toString();
		} 
		return response; 
	}

	
	
	 

	@Override
	public Response editarProducto(ProductosDTO productoDTO) {
		Response response = new Response();
		
		try {
			 
			response = productoMapper.editarProducto(productoDTO);
			 
		}catch (HttpClientErrorException e) { 
			
			if(e.getRawStatusCode()== 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
			}
			else if(e.getRawStatusCode()== 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
			}
			else if(e.getRawStatusCode()== 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
			}

		} catch(Exception e) {
			e.getMessage();
		} 
 		return response;
	}


	
	
	@Override
	public Response eliminarProductoCodigo(String codigoProducto) {
		Response response = new Response();

		try {

			response = productoMapper.eliminarProductoCodigo(codigoProducto);

		} catch (HttpClientErrorException e) {

			if (e.getRawStatusCode() == 404) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("No encontrado");
			} else if (e.getRawStatusCode() == 500) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("Error interno");
			} else if (e.getRawStatusCode() == 409) {
				response.setIdTransaccion(UUID.randomUUID().toString());
				response.setMensaje("conflict");
			} 
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}


  

}
