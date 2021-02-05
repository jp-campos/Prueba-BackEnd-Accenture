package model;

import java.util.ArrayList;

import com.accenture.prueba.dto.Pedido;

public class PedidoSingleton {
	
	
	private static final PedidoSingleton pedidos = new PedidoSingleton();
	
	private ArrayList<Pedido> persistencia ;
	
	
	public PedidoSingleton() {
		persistencia = new ArrayList<>();
		//TODO: Esto
		
	}; 
	
	
	public static PedidoSingleton getIntancia() {
		return pedidos;
	}

}
