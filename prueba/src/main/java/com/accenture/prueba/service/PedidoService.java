package com.accenture.prueba.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.accenture.prueba.dto.Factura;
import com.accenture.prueba.dto.Pedido;
import com.accenture.prueba.dto.Producto;
import com.accenture.prueba.model.PedidoSingleton;
import com.accenture.prueba.model.ProductoSingleton;

@Service
public class PedidoService {

	
	public PedidoService(){};
	
	
	public ArrayList<Pedido> getPedidos(){
		return PedidoSingleton.getIntance().getPedidos();
	}
	
	public Pedido crearPedido(Pedido pedido) {
		
		PedidoSingleton pedidoSingle = PedidoSingleton.getIntance(); 
		
		pedido = adjuntarPrecios(pedido); 
		double total = precioTotalPedido(pedido);
		
		
		Factura f = null;
				
		if(total > 70000) {
			f = new Factura( total, Factura.DOMICILIO , total*0.19 );

		}else if( total > 100000) {
			f = new Factura (total,0,total * 0.19);
		}
		
		//Set los valores extra del pedido
		LocalDateTime dt = LocalDateTime.now();
		pedido.setFechaHora(dt);
		
		pedido.setFactura(f);
		
		pedidoSingle.createPedido(pedido);
		
		return pedido;
	}
	
	
	public Pedido actualizarPedido(Pedido pedido) throws Exception {
		
		PedidoSingleton pedidoSingle = PedidoSingleton.getIntance(); 
		
		Pedido pViejo = pedidoSingle.getPedido(pedido.getId());
		
		LocalDateTime dtViejo = pViejo.getFechaHora();
		LocalDateTime dtNuevo = pViejo.getFechaHora();
		
		long horas = Duration.between(dtViejo, dtNuevo).toHours(); 
		if( horas < 5) {
			
			pedido = adjuntarPrecios(pedido); 
			double total = precioTotalPedido(pedido);
			
			Factura f = null;
					
			if(total > 70000) {
				f = new Factura( total, Factura.DOMICILIO , total*0.19 );

			}else if( total > 100000) {
				f = new Factura (total,0,total * 0.19);
			}
			
			//Set los valores extra del pedido
			LocalDateTime dt = LocalDateTime.now();
			pedido.setFechaHora(dt);
			
			pedido.setFactura(f);
			
			double nuevoPrecio = precioTotalPedido(pedido);
			if(pViejo.getFactura()!= null && nuevoPrecio > 70000 ) {
				pedido.setFactura(new Factura(nuevoPrecio,0, nuevoPrecio*0.19));
			}
			
			
		}else{
			throw new Exception("No se puede actualizar un pedido 5 horas después de ser creado");
		}
		
		Pedido retorno = pedidoSingle.updatePedido(pedido.getId(), pedido);
		
		if(retorno == null) {
			throw new Exception("No se encontró el producto con el id " + pedido.getId());
		}
		return retorno;
	}
	
	public Pedido cancelarPedido(long id) throws Exception{
		PedidoSingleton pedidoSingle = PedidoSingleton.getIntance(); 
		
		Pedido pViejo = pedidoSingle.getPedido(id);
		
		LocalDateTime dtViejo = pViejo.getFechaHora();
		LocalDateTime dtNuevo = pViejo.getFechaHora();
		
		long horas = Duration.between(dtViejo, dtNuevo).toHours(); 

		if(horas<12) {
			Pedido retorno = pedidoSingle.deletePedido(id);
			if(retorno == null) {
				throw new Exception("No se encontró el producto con el id " + id);
			}
			return retorno;
			
		}else{
			double nuevoValor = pViejo.getFactura().getValorTotal()*0.1;
			Pedido pFactura0 = pedidoSingle.deletePedido(id);
			pFactura0.setFactura(new Factura(nuevoValor,0,0));
			return pFactura0;
		}
		
	}
	
	
	
	//------------------------------------------
	//              Métodos privados
	//------------------------------------------
	
	private double precioTotalPedido(Pedido pedido) {
				
		ArrayList<Producto> productos = pedido.getProductos();
		double total = 0;
		for (Producto producto : productos) {
			
			int cantidad = producto.getCantidad();
			total+= cantidad * producto.getPrecio(); 
		}
		
		return total;
	}
	
	private Pedido adjuntarPrecios(Pedido pedido) {
		
		ProductoSingleton productoSingle = ProductoSingleton.getInstance(); 
		
		ArrayList<Producto> productos = pedido.getProductos();
		for (Producto producto : productos) {
			Producto productoBd = productoSingle.getProductoPorNombre(producto.getNombre());
			producto.setPrecio(productoBd.getPrecio());
		}
		
		return pedido;
	}
	
	
}
