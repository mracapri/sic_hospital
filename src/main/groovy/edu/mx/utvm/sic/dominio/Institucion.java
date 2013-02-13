package edu.mx.utvm.sic.dominio;

public class Institucion {
	private int id;
	private int id_estado;
	private int id_municipio;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_estado() {
		return id_estado;
	}
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	public int getId_municipio() {
		return id_municipio;
	}
	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
