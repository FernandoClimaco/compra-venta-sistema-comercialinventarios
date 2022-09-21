package com.comercial.dto;

import java.util.Date;  
import com.comercial.entidades.CodigoCliente;

public class ClientesDTO {
	 
	private int idCliente; 
	private Date fechaRegistro; 
	private CodigoCliente codigoCliente; 
	private String nombres; 
	private String apellidos; 
	private String dui; 
	private String nit; 
	private String telefonos; 
	private String direccon; 
	private String correoElectronico;
	
	public ClientesDTO(int idCliente, Date fechaRegistro, CodigoCliente codigoCliente, String nombres, String apellidos,
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

	public ClientesDTO() {
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
		builder.append("ClientesDTO [idCliente=");
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
