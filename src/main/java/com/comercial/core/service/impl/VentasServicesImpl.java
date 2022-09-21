package com.comercial.core.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.comercial.core.service.VentasServices;
import com.comercial.entidades.Productos;
import com.comercial.entidades.Ventas;
import com.comercial.repositorio.ProductosRepositorio;
import com.comercial.repositorio.VentasRepositorio;
import com.comercial.response.Response;


@Service
public class VentasServicesImpl implements VentasServices {
	
	@Autowired
	private VentasRepositorio ventasRepositorio;
	
	@Autowired
	private ProductosRepositorio productosRepositorio;

	
	@Override
	public List<Ventas> listarTodasLasVentas() {

		List<Ventas> lst = null;

		try {
			
			lst = ventasRepositorio.findAll();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	
	@Override
	public List<Ventas> listarTodasLasVentasConPaginacion(int pageNo, int numeroRegistro, String busqueda, String sortDir) {
		List<Ventas> lst = null;

		try {
			Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(busqueda).ascending() : Sort.by(busqueda).descending();
			Pageable pageable = PageRequest.of(pageNo, numeroRegistro, sort);
			Page<Ventas> v =  ventasRepositorio.findAll(pageable);
			
			lst = v.getContent();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return lst;
	}

	
	
	@Override
	public Response guardarVenta(Ventas ventas) {
		Response response = new Response();

		try {

			List<Productos> y = productosRepositorio.busquedaPorCodigoProducto(ventas.getProductos().getCodigoProducto());

			if (y == null) {
				System.out.println("datos no encontrados, No puede vender");
			} else {

				if (y.get(0).getStock() < 0) {
					System.out.println("No puede vender , la cantidad del producto :" + y.get(0).getNombreProducto()
							+ ", es de CERO");
				} else {

					// 1- si el stock en la base de datos es mayor al stock ingresado por el
					// usuario:
					if (y.get(0).getStock() > ventas.getProductos().getStock()) {
						// 2- Disminuimos el stock:
						int stock = 0;
						stock = y.get(0).getStock() - ventas.getProductos().getStock();
						y.get(0).setStock(stock);

						// Editamos el stock
						productosRepositorio.save(y.get(0));

						// realizamos la venta
						Ventas vv = ventasRepositorio.save(ventas);

						if (vv != null) {
							response.setIdTransaccion(UUID.randomUUID().toString());
							response.setMensaje("Venta realizada");
						} else {
							response.setIdTransaccion(UUID.randomUUID().toString());
							response.setMensaje("Venta no realizada, revisar base de datos");
						}

					} else {
						System.out.println("La cantidad del producto es de CERO , NO se realizo la venta");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	

}
