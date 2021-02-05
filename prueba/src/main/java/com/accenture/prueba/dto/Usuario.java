package com.accenture.prueba.dto;

public class Usuario {
	
	
	private final long id; 
	private final String cedula;
	private final String direccion;
	
	
	public Usuario(long id, String cedula, String direccion) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.direccion = direccion;
	}
	
	
	public long getId() {
		return id;
	}
	public String getCedula() {
		return cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	
	
	
	

}
