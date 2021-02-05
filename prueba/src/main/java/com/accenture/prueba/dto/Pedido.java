package com.accenture.prueba.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	
	private ArrayList<Producto> productos;
	private LocalDateTime fechaHora;
	
	public Pedido(ArrayList<Producto> productos, LocalDateTime fechaHora) {
		super();
		this.productos = productos;
		this.fechaHora = fechaHora;
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	} 
	
	
	

}
