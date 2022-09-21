package com.comercial.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comercial.entidades.Clientes;

@Repository
public interface ClientesRepositorio  extends JpaRepository<Clientes, Integer>{
	
	@Query("select c from Clientes c where c.codigoCliente=?1")
	public List<Clientes> buscarPorCodigoCliente(String codigoCliente);
	
	@Query("select c from Clientes c where c.dui=?1")
	public List<Clientes> buscarPorDuiCliente(String dui);
	
	@Query("select c from Clientes c where c.codigoCliente=?1 and c.dui=?2")
	public List<Clientes> buscarPorCodigoYDuiClientes(String codigoCliente, String dui);

}
