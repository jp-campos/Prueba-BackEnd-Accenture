package com.accenture.prueba.model;

import java.util.ArrayList;
import com.accenture.prueba.dto.Factura;

public class FacturaSingleton {
	
	private static FacturaSingleton facturas = new FacturaSingleton();
	
	private ArrayList<Factura> persistencia;
	
	private FacturaSingleton() {
		persistencia = new ArrayList<>();
		//TODO: Inicializar (?)
		
	}

	
	public static FacturaSingleton getInstance() {
		return facturas;
	}
	
	public ArrayList<Factura> getFacturas(){
		return persistencia;
	}
}
