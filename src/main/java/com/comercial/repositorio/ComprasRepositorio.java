package com.comercial.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comercial.entidades.Compras;

@Repository
public interface ComprasRepositorio extends JpaRepository<Compras, Integer> {
	
	@Query("select c from Compras c where c.numeroSerieComprobante = ?1")
	List<Compras> buscarPorNumeroSerieComprobante(String numeroSerieComprobante);

}
