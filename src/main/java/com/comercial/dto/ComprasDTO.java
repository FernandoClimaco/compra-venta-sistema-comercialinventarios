package com.comercial.dto;

public class ComprasDTO {
	
	private int idCompras;
	private String fechaCompras;
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
	private String codigoEmpleado;
	
	
	public ComprasDTO(int idCompras, String fechaCompras, String tipoComprobante, String numeroSerieComprobante,
			int idProducto, String fechaRegistro, String codigoProducto, String nombreProducto, int stock,
			double precioUnitario, double total, double iva, String codigoEmpleado) {
		super();
		this.idCompras = idCompras;
		this.fechaCompras = fechaCompras;
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
		this.codigoEmpleado = codigoEmpleado;
	}
	public ComprasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCompras() {
		return idCompras;
	}
	public void setIdCompras(int idCompras) {
		this.idCompras = idCompras;
	}
	public String getFechaCompras() {
		return fechaCompras;
	}
	public void setFechaCompras(String fechaCompras) {
		this.fechaCompras = fechaCompras;
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
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComprasDTO [idCompras=");
		builder.append(idCompras);
		builder.append(", fechaCompras=");
		builder.append(fechaCompras);
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
		builder.append(", codigoEmpleado=");
		builder.append(codigoEmpleado);
		builder.append("]");
		return builder.toString();
	}
	 
	
	
	 
	
	 

}
