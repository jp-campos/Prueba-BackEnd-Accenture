package com.accenture.prueba.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.http.HttpStatus;

import com.accenture.prueba.dto.Pedido;
import com.accenture.prueba.error.ErrorMsg;
import com.accenture.prueba.service.PedidoService;


@RestController
public class PedidoController {

	@Autowired
	PedidoService logica;
	
	@GetMapping("/pedidos")
	public ArrayList<Pedido> getPedidos(){
		return logica.getPedidos();
	}
	@PostMapping("/pedido")
	public Pedido crearPedido(@RequestBody Pedido pedido) {
		return logica.crearPedido(pedido);
	}
	
	@PutMapping("/pedido")
	public Pedido actualizarPedido(@RequestBody Pedido pedido) throws Exception{
		return logica.actualizarPedido(pedido);
	}
	
	@DeleteMapping("/pedido")
	public Pedido cancelarPedido(@RequestParam(value="id")long id) throws Exception{
		System.out.println("cancelarPedido() en PedidoController");
		return logica.cancelarPedido(id);
	}
	
	
	
    @ExceptionHandler({ Exception.class })
    public ErrorMsg handleException(Exception e) {
    
        return new ErrorMsg(e.getMessage()); 
    }
	
}
