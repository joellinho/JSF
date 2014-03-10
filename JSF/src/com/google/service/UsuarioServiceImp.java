package com.google.service;

import java.util.List;

import com.google.factory.DaoFactory;
import com.google.jpa.UsuarioJPA;

public class UsuarioServiceImp implements UsuarioService{

	DaoFactory factory= DaoFactory.getFactory(1);
	UsuarioService dao= factory.getUsuario();
	
	@Override
	public UsuarioJPA BuscarUsuario(UsuarioJPA usuario) throws Exception {
		// TODO Auto-generated method stub
		return dao.BuscarUsuario(usuario);
	}

	@Override
	public boolean RegistrarUsuario(UsuarioJPA usuario) throws Exception {
		// TODO Auto-generated method stub
		return dao.RegistrarUsuario(usuario);
	}

	@Override
	public boolean ActualizarUsuario(UsuarioJPA usuario) throws Exception {
		// TODO Auto-generated method stub
		return dao.ActualizarUsuario(usuario);
	}

	@Override
	public boolean EliminarUsuario(UsuarioJPA usuario) throws Exception {
		// TODO Auto-generated method stub
		return dao.EliminarUsuario(usuario);
	}

	@Override
	public List<UsuarioJPA> ListarUsuarios(UsuarioJPA usuario) throws Exception {
		// TODO Auto-generated method stub
		return dao.ListarUsuarios(usuario);
	}



}
