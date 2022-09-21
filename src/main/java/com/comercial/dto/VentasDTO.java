package com.comercial.dto;

public class VentasDTO {
	
	private int idVentas;
	private String fechaVenta;
	private String tipoComprobante;
	private String numeroSerieComprobante;
	private int idProducto;
	private String fechaRegistro;
	private String codigoProducto;
	private String nombreProducto;
	private int stock;
	private double precioUnitario;
	private double total;
	private double iva;
	private String empleado;
	private int idCliente;
	private String fechaRegistroCliente;
	private String codigoCliente;
	private String nombres;
	private String apellidos;
	private String dui;
	private String nit;
	private String telefonos;
	private String direccion;
	private String correoElectronico;
	
	public VentasDTO(int idVentas, String fechaVenta, String tipoComprobante, String numeroSerieComprobante,
			int idProducto, String fechaRegistro, String codigoProducto, String nombreProducto, int stock,
			double precioUnitario, double total, double iva, String empleado, int idCliente,
			String fechaRegistroCliente, String codigoCliente, String nombres, String apellidos, String dui, String nit,
			String telefonos, String direccion, String correoElectronico) {
		super();
		this.idVentas = idVentas;
		this.fechaVenta = fechaVenta;
		this.tipoComprobante = tipoComprobante;
		this.numeroSerieComprobante = numeroSerieComprobante;
		this.idProducto = idProducto;
		this.fechaRegistro = fechaRegistro;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
		this.total = total;
		this.iva = iva;
		this.empleado = empleado;
		this.idCliente = idCliente;
		this.fechaRegistroCliente = fechaRegistroCliente;
		this.codigoCliente = codigoCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dui = dui;
		this.nit = nit;
		this.telefonos = telefonos;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
	}

	public VentasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getNumeroSerieComprobante() {
		return numeroSerieComprobante;
	}

	public void setNumeroSerieComprobante(String numeroSerieComprobante) {
		this.numeroSerieComprobante = numeroSerieComprobante;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaRegistroCliente() {
		return fechaRegistroCliente;
	}

	public void setFechaRegistroCliente(String fechaRegistroCliente) {
		this.fechaRegistroCliente = fechaRegistroCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
		builder.append("VentasDTO [idVentas=");
		builder.append(idVentas);
		builder.append(", fechaVenta=");
		builder.append(fechaVenta);
		builder.append(", tipoComprobante=");
		builder.append(tipoComprobante);
		builder.append(", numeroSerieComprobante=");
		builder.append(numeroSerieComprobante);
		builder.append(", idProducto=");
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
		builder.append(", total=");
		builder.append(total);
		builder.append(", iva=");
		builder.append(iva);
		builder.append(", empleado=");
		builder.append(empleado);
		builder.append(", idCliente=");
		builder.append(idCliente);
		builder.append(", fechaRegistroCliente=");
		builder.append(fechaRegistroCliente);
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
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", correoElectronico=");
		builder.append(correoElectronico);
		builder.append("]");
		return builder.toString();
	}
	
	
	 

}
