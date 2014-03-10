package com.google.factory;

import com.google.service.UsuarioService;

public abstract class DaoFactory {
	
	public static final int MYSQL=1;
	public static final int JPA=2;
	public abstract UsuarioService getUsuario();
	
	public static DaoFactory getFactory(int bd){
		
		switch (bd) {
		case 1:
			return new MySQLDAOFactory();
		default:
			break;
		}
		return null;
	}
}
