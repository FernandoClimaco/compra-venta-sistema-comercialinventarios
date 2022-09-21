package com.comercial.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.entidades.Ventas;

@Repository
public interface VentasRepositorio extends JpaRepository<Ventas, Integer> {

}
