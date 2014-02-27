package com.google.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="cliente")
public class Cliente {
<<<<<<< HEAD
	
	// Connect Successfull
	
=======
	// Testing for branch
>>>>>>> origin/Gerson-Silva
	private String Nombre="Luyito Gay";

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
