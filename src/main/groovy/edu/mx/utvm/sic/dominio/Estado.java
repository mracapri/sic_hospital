package edu.mx.utvm.sic.dominio;

public class Estado {
	private int id;
	private String clave;
	private String descripcion;
	private String avrev;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAvrev() {
		return avrev;
	}
	public void setAvrev(String avrev) {
		this.avrev = avrev;
	}	
}
