package com.google.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="cliente")
public class Cliente {

	private String Nombre="User";

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}	
	
//<!-- Asignamos en el value el valor en el faces.config, que obtiene los datos desde el mensaje.properties -->
//<h:outputLabel id="lblNombre" value="#{msg['cliente.Nombre']}"></h:outputLabel>
//<!-- Asi llamamos de frente a un backing beans -->
//<h:inputText id="txtNombre" value="#{cliente.nombre}" /> 
//<br />

//<!-- Asignamos en el value el valor en el faces.config, que obtiene los datos desde el mensaje.properties-->
//<!-- Llamando a un BackingBean-->
//<h:commandButton value="#{msg['button.Procesar']}" 
//action="#{controllerCliente.validar}" /> 

	
}
