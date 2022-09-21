package com.comercial.dto;

import java.util.Date;

 

public class ProductosDTO {
	
 
	private int idProducto; 
	private Date fechaRegistro; 
	private String codigoProducto; 
	private String nombreProducto; 
	private int stock; 
	private double precioUnitario;
	
	
	public ProductosDTO(int idProducto, Date fechaRegistro, String codigoProducto, String nombreProducto, int stock,
			double precioUnitario) {
		super();
		this.idProducto = idProducto;
		this.fechaRegistro = fechaRegistro;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}


	public ProductosDTO() {
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
		builder.append("ProductosDTO [idProducto=");
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
