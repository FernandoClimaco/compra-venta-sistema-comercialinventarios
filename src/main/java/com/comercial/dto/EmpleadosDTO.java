package com.comercial.dto;

import java.util.Date; 

public class EmpleadosDTO {
	
	 
	private int idEmpleado; 
	private Date fechaContratacion; 
	private String codigoEmpleado; 
	private String tipoDeContrato; 
	private String dui; 
	private String nit; 
	private String telefonos; 
	private double sueldoMensual;
	
	
	public EmpleadosDTO(int idEmpleado, Date fechaContratacion, String codigoEmpleado, String tipoDeContrato,
			String dui, String nit, String telefonos, double sueldoMensual) {
		super();
		this.idEmpleado = idEmpleado;
		this.fechaContratacion = fechaContratacion;
		this.codigoEmpleado = codigoEmpleado;
		this.tipoDeContrato = tipoDeContrato;
		this.dui = dui;
		this.nit = nit;
		this.telefonos = telefonos;
		this.sueldoMensual = sueldoMensual;
	}
	
	public EmpleadosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public String getTipoDeContrato() {
		return tipoDeContrato;
	}
	public void setTipoDeContrato(String tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
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
	public double getSueldoMensual() {
		return sueldoMensual;
	}
	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpleadosDTO [idEmpleado=");
		builder.append(idEmpleado);
		builder.append(", fechaContratacion=");
		builder.append(fechaContratacion);
		builder.append(", codigoEmpleado=");
		builder.append(codigoEmpleado);
		builder.append(", tipoDeContrato=");
		builder.append(tipoDeContrato);
		builder.append(", dui=");
		builder.append(dui);
		builder.append(", nit=");
		builder.append(nit);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append(", sueldoMensual=");
		builder.append(sueldoMensual);
		builder.append("]");
		return builder.toString();
	}
	
	
	

	

}
