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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compras")
public class Compras implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int idCompras;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaCompras;
	
	@Column
	private TipoComprobante tipoComprobante;
	
	@Column
	private String numeroSerieComprobante;
	
	@ManyToOne
	@JoinColumn(name="idproductos")
	private Productos idProductos;
	
	@ManyToOne
	@JoinColumn(name="idempleados")
	private Empleados idEmpleados;

	public Compras(int idCompras, Date fechaCompras, TipoComprobante tipoComprobante, String numeroSerieComprobante,
			Productos idProductos, Empleados idEmpleados) {
		super();
		this.idCompras = idCompras;
		this.fechaCompras = fechaCompras;
		this.tipoComprobante = tipoComprobante;
		this.numeroSerieComprobante = numeroSerieComprobante;
		this.idProductos = idProductos;
		this.idEmpleados = idEmpleados;
	}

	public Compras() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCompras() {
		return idCompras;
	}

	public void setIdCompras(int idCompras) {
		this.idCompras = idCompras;
	}

	public Date getFechaCompras() {
		return fechaCompras;
	}

	public void setFechaCompras(Date fechaCompras) {
		this.fechaCompras = fechaCompras;
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

	public Productos getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(Productos idProductos) {
		this.idProductos = idProductos;
	}

	public Empleados getIdEmpleados() {
		return idEmpleados;
	}

	public void setIdEmpleados(Empleados idEmpleados) {
		this.idEmpleados = idEmpleados;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compras [idCompras=");
		builder.append(idCompras);
		builder.append(", fechaCompras=");
		builder.append(fechaCompras);
		builder.append(", tipoComprobante=");
		builder.append(tipoComprobante);
		builder.append(", numeroSerieComprobante=");
		builder.append(numeroSerieComprobante);
		builder.append(", idProductos=");
		builder.append(idProductos);
		builder.append(", idEmpleados=");
		builder.append(idEmpleados);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
