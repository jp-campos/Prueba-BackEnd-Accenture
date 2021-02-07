package com.accenture.prueba.dto;

public class Factura {
	
	public static final int DOMICILIO = 2500;
	
	private double valorTotal;	
	private int valorDomicilio;
	private double iva;
	
	
	public Factura(double valorTotal,int valorDomicilio, double iva) {
		super();
		this.valorTotal = valorTotal;
		this.valorDomicilio = valorDomicilio;
		this.iva = iva;
	}
	
	public double getValorDomicilio() {
		return valorDomicilio;
	}
	
	public void setValorDomicilio(int valorDomicilio) {
		this.valorDomicilio = valorDomicilio;
	}
	
	public double getIva() {
		return iva;
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	} 
	
	
	
}
