package com.comercial.repositorio;

import java.util.HashMap;
import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comercial.entidades.Productos;
@Repository
public interface ProductosRepositorio extends JpaRepository<Productos, Integer> {
	
	
	// 1- Busqueda por codigoProducto
	@Query("select p from Productos p where p.codigoProducto =?1")
	public List<Productos> busquedaPorCodigoProducto(String codigoProducto);
	
	
	@Query("select p from Productos p where p.codigoProducto= ?1 and p.stock = ?2")
	public List<Productos> findByProductos(String codigoProducto,int stock);
	
	
	public List<Productos> getData(HashMap<String, Object> conditions);

	
}
