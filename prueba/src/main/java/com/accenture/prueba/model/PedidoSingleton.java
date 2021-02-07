package com.accenture.prueba.model;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.accenture.prueba.dto.Factura;
import com.accenture.prueba.dto.Pedido;

public class PedidoSingleton {
	
	
	private static final PedidoSingleton pedidos = new PedidoSingleton();
	
	private ArrayList<Pedido> persistencia;
	private final AtomicLong counter = new AtomicLong();

	
	public PedidoSingleton() {
		persistencia = new ArrayList<>();
	}; 
	
	
	public static PedidoSingleton getIntance() {
		return pedidos;
	}
	
	
	public Pedido createPedido(Pedido p) {
		p.setId(counter.getAndIncrement());
		persistencia.add(p);

		return persistencia.get(persistencia.size() -1 ); 
	}
	
	public ArrayList<Pedido> getPedidos(){
		return persistencia;
	}
	
	public Pedido getPedido(long id) {
		for(Pedido p : persistencia) {
			return p;
		}
		return null;
	}
	
	public Pedido updatePedido(long id, Pedido pPedido){
		
		for (Pedido pedido : persistencia) {
			if(pedido.getId() == id ) {
				pedido.update(pPedido);
				return pedido;
			}
		}
		return null; 
	}
	

	public Pedido deletePedido(long id) {
		for (int i = 0; i < persistencia.size(); i++) {
			Pedido p = persistencia.get(i);
			
			if(p.getId() == id) {
				
				persistencia.remove(i);
				p.setFactura(new Factura(0, 0, 0));
				return p;
			}
			
		}
		
		return null;
		
	}
}
