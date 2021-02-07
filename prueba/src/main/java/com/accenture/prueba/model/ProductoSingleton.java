package com.accenture.prueba.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.accenture.prueba.dto.Producto;

public class ProductoSingleton {
		
	private final static ProductoSingleton productos = new ProductoSingleton();
	
	private ArrayList<Producto> persistencia;
	
	private ProductoSingleton() {
		
		persistencia = new ArrayList<>();
		persistencia.add(new Producto("changua", 20000, 2)); 
		persistencia.add(new Producto("tamal", 50000, 3));
	};
	
	
	public static ProductoSingleton getInstance() {
		return productos;
	}
	
	
	public ArrayList<Producto> getProductos() {
		return persistencia;
	}
	
	public Producto getProductoPorNombre(String name){
		for (Producto producto : persistencia) {
			if(producto.getNombre().equals(name)) {
				return producto;
			}
		}
		return null; 
	}
	
	public List<Producto> getProductosPorNombre(ArrayList<String> nombres){
		return persistencia.stream().filter( p -> nombres.contains(p.getNombre())).collect(Collectors.toList()); 
	}
	

}
