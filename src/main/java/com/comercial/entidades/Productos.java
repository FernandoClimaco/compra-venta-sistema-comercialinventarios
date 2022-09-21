package com.comercial.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="productos")
public class Productos implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private int idProducto;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@Column
	private String codigoProducto;
	
	@Column
	private String nombreProducto;
	
	@Column
	private int stock;
	
	@Column
	private double precioUnitario;

	public Productos(int idProducto, Date fechaRegistro, String codigoProducto, String nombreProducto, int stock,
			double precioUnitario) {
		super();
		this.idProducto = idProducto;
		this.fechaRegistro = fechaRegistro;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}

	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Productos [idProducto=");
		builder.append(idProducto);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append(", codigoProducto=");
		builder.append(codigoProducto);
		builder.append(", nombreProducto=");
		builder.append(nombreProducto);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", precioUnitario=");
		builder.append(precioUnitario);
		builder.append("]");
		return builder.toString();
	}
	
	 

}
