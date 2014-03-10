package com.google.factory;

import com.google.dao.UsuarioDAO;
import com.google.service.UsuarioService;

public class MySQLDAOFactory extends DaoFactory{

	@Override
	public UsuarioService getUsuario() {
		// TODO Auto-generated method stub
		return new UsuarioDAO();
	}

}
