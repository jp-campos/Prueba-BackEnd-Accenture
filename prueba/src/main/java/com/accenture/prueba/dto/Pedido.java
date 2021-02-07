package com.accenture.prueba.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	
	private long id;
	private ArrayList<Producto> productos;
	private LocalDateTime fechaHora;
	private Factura factura;
	
	
	public Pedido(ArrayList<Producto> productos, LocalDateTime fechaHora, Factura factura, long id) {
		super();
		this.id = id;
		this.productos = productos;
		this.fechaHora = fechaHora;
		this.factura = factura;
	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public void update(Pedido pedido) {
		this.id = pedido.id;
		this.productos = pedido.productos;
		this.fechaHora = pedido.fechaHora;
		this.factura = pedido.factura;
	}


	
	

	
	
	

}
