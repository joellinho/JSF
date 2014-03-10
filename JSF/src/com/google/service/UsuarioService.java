package com.google.service;

import java.util.List;

import com.google.jpa.UsuarioJPA;

public interface UsuarioService {

	public abstract UsuarioJPA BuscarUsuario(UsuarioJPA usuario) throws Exception;
	
	public abstract boolean RegistrarUsuario(UsuarioJPA usuario) throws Exception;
	public abstract boolean ActualizarUsuario(UsuarioJPA usuario) throws Exception;
	public abstract boolean EliminarUsuario(UsuarioJPA usuario) throws Exception;
	public abstract List<UsuarioJPA> ListarUsuarios(UsuarioJPA usuario) throws Exception;
	
}
