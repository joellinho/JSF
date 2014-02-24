package com.google.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ControllerCliente {

	@ManagedProperty(value="#{cliente}")
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String validar(){
		if(cliente.getNombre().equals("Miguel")){
			return "home";
		}
		else{
			return "fallo";
		}
	}
	
}
