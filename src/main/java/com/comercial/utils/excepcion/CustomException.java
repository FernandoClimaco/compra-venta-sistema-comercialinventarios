package com.comercial.utils.excepcion;

 
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException  { 
	
	private static final long serialVersionUID = 1L;
    
	
     private Object nombreDelRecurso;
     private String descripcionError;
     private long status;
	public CustomException(Object nombreDelRecurso, String descripcionError, long status) {
		super( String.format( "%s  %s : '%s'" ,   nombreDelRecurso,descripcionError,status)    );
		this.nombreDelRecurso = nombreDelRecurso;
		this.descripcionError = descripcionError;
		this.status = status;
	}
	public Object getNombreDelRecurso() {
		return nombreDelRecurso;
	}
	public void setNombreDelRecurso(Object nombreDelRecurso) {
		this.nombreDelRecurso = nombreDelRecurso;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomException [nombreDelRecurso=");
		builder.append(nombreDelRecurso);
		builder.append(", descripcionError=");
		builder.append(descripcionError);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	 
     
	
}
