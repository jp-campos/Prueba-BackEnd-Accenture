package com.accenture.prueba.dto;

public class Factura {
	
	
	private double valorDomicilio;
	private double iva;
	
	public Factura(double valorDomicilio, double iva) {
		super();
		this.valorDomicilio = valorDomicilio;
		this.iva = iva;
	}
	
	public double getValorDomicilio() {
		return valorDomicilio;
	}
	
	public void setValorDomicilio(double valorDomicilio) {
		this.valorDomicilio = valorDomicilio;
	}
	
	public double getIva() {
		return iva;
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	} 
	
	
	
}
