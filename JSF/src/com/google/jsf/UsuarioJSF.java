package com.google.jsf;

import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.google.jpa.UsuarioJPA;
import com.google.service.UsuarioServiceImp;

@ManagedBean(name="usuario")
@RequestScoped
public class UsuarioJSF {
	
	private int id ;
	private int rol_id ;
	private String usuario;
	private String clave;
	private String email;
	private int estado;
	private String usuariocreacion;
	private Date fechacreacion;
	private String usuariomodificacion;
	private Date fechamodificacion;
	
	private UsuarioServiceImp usuarioImpl = new UsuarioServiceImp();
	
	public String Validar(){
		String vista="fallo";
		UsuarioJPA usuarioJpa = new UsuarioJPA();
		
		try {
			usuarioJpa.setUsuario(getUsuario());
			usuarioJpa.setClave(getClave());	
			
			UsuarioJPA result=usuarioImpl.BuscarUsuario(usuarioJpa);
			
			System.out.println("-->"+ usuarioJpa.getUsuario());
			if(result!=null){
				vista="home";				
			}
			
		} catch (Exception e) {
			System.out.println("Error UsuarioJSF: " + e.getMessage());
		}		
		return vista;	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRol_id() {
		return rol_id;
	}
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getUsuariocreacion() {
		return usuariocreacion;
	}
	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public String getUsuariomodificacion() {
		return usuariomodificacion;
	}
	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}
	public Date getFechamodificacion() {
		return fechamodificacion;
	}
	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

}
