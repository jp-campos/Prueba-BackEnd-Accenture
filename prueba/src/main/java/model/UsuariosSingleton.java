package model;

import java.util.ArrayList;

import com.accenture.prueba.dto.Usuario;

public class UsuariosSingleton {
	
	private static final UsuariosSingleton usuarios = new UsuariosSingleton();
	
	private ArrayList<Usuario> persistencia;
	
	private UsuariosSingleton() {
		//Carga predeterminada
		persistencia.add(new Usuario(1, "12345", "carrera 11# 14-08"));
	}; 
	
	public static UsuariosSingleton getInstance() {
		return usuarios;
	}
	
	
	public ArrayList<Usuario> getUsuarios() {
		
		return persistencia;
	}	
	
	
	public void addUsuario(Usuario usuario) {
		persistencia.add(usuario);
	}
	

}
