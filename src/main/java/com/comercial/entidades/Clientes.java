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
@Table(name = "clientes")
public class Clientes implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idCliente;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@Column
	private CodigoCliente codigoCliente;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column
	private String dui;
	
	@Column
	private String nit;
	
	@Column
	private String telefonos;
	
	@Column
	private String direccon;
	
	@Column
	private String correoElectronico;
	
	
	
	public Clientes(int idCliente, Date fechaRegistro, CodigoCliente codigoCliente, String nombres, String apellidos,
			String dui, String nit, String telefonos, String direccon, String correoElectronico) {
		super();
		this.idCliente = idCliente;
		this.fechaRegistro = fechaRegistro;
		this.codigoCliente = codigoCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dui = dui;
		this.nit = nit;
		this.telefonos = telefonos;
		this.direccon = direccon;
		this.correoElectronico = correoElectronico;
	}

	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public CodigoCliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(CodigoCliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getDireccon() {
		return direccon;
	}

	public void setDireccon(String direccon) {
		this.direccon = direccon;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clientes [idCliente=");
		builder.append(idCliente);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append(", codigoCliente=");
		builder.append(codigoCliente);
		builder.append(", nombres=");
		builder.append(nombres);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", dui=");
		builder.append(dui);
		builder.append(", nit=");
		builder.append(nit);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append(", direccon=");
		builder.append(direccon);
		builder.append(", correoElectronico=");
		builder.append(correoElectronico);
		builder.append("]");
		return builder.toString();
	}
	
	 
}
