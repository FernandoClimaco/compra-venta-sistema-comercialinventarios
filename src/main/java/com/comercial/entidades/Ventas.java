package com.comercial.entidades;

import java.io.Serializable;
import java.util.Date; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Ventas implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
	@Column
	private int idVentas;
	
	@Column
	private Date fechaVenta;
	
	@Column
	private TipoComprobante tipoComprobante;
	
	@Column
	private String numeroSerieComprobante;
	
	@ManyToOne
	@JoinColumn(name="productos")
	private Productos productos;
	 
	@ManyToOne
	@JoinColumn(name="idEmpleados")
	private Empleados idEmpleados;
	
	@ManyToOne
	@JoinColumn(name="idClientes")
	private Clientes idClientes;

	public Ventas(int idVentas, Date fechaVenta, TipoComprobante tipoComprobante, String numeroSerieComprobante,
			Productos productos,   Empleados idEmpleados, Clientes idClientes) {
		super();
		this.idVentas = idVentas;
		this.fechaVenta = fechaVenta;
		this.tipoComprobante = tipoComprobante;
		this.numeroSerieComprobante = numeroSerieComprobante;
		this.productos = productos; 
		this.idEmpleados = idEmpleados;
		this.idClientes = idClientes;
	}

	public Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getNumeroSerieComprobante() {
		return numeroSerieComprobante;
	}

	public void setNumeroSerieComprobante(String numeroSerieComprobante) {
		this.numeroSerieComprobante = numeroSerieComprobante;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}
 

	public Empleados getIdEmpleados() {
		return idEmpleados;
	}

	public void setIdEmpleados(Empleados idEmpleados) {
		this.idEmpleados = idEmpleados;
	}

	public Clientes getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(Clientes idClientes) {
		this.idClientes = idClientes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ventas [idVentas=");
		builder.append(idVentas);
		builder.append(", fechaVenta=");
		builder.append(fechaVenta);
		builder.append(", tipoComprobante=");
		builder.append(tipoComprobante);
		builder.append(", numeroSerieComprobante=");
		builder.append(numeroSerieComprobante);
		builder.append(", productos=");
		builder.append(productos); 
		builder.append(", idEmpleados=");
		builder.append(idEmpleados);
		builder.append(", idClientes=");
		builder.append(idClientes);
		builder.append("]");
		return builder.toString();
	}

	 
	
	
	

}
