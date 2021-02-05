package com.accenture.prueba.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba.dto.Factura;
import com.accenture.prueba.dto.Pedido;


@RestController
public class PedidoController {

	
	
	@PostMapping("/pedido")
	public Factura crearPedido(@RequestBody Pedido pedido) {
		
		return new Factura(1,2);
	}
	
	@PutMapping("/pedido")
	public Factura actualizarPedido(@RequestBody Pedido pedido) {
		
		return new Factura(1,2);
	}
	
}
