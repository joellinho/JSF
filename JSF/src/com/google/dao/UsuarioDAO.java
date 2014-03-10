package com.google.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.jpa.UsuarioJPA;
import com.google.service.UsuarioService;

public class UsuarioDAO implements UsuarioService {

	// JSF viene del archivo persistence.xml
	EntityManagerFactory emf;
	EntityManager em;

	public void abrir() {
		emf = Persistence.createEntityManagerFactory("JSF");
		em = emf.createEntityManager();
	}

	public void cerrar() {
		emf.close();
		em.close();
	}

	@Override
	public UsuarioJPA BuscarUsuario(UsuarioJPA usuario) throws Exception {

		UsuarioJPA objUser = null;
		abrir();
		try {
			Query q = em.createQuery("select u from UsuarioJPA u where u.usuario = :usuario and u.clave = :clave");
			q.setParameter("usuario",usuario.getUsuario());
			q.setParameter("clave",usuario.getClave());
			objUser=(UsuarioJPA) q.getSingleResult();
			
			System.out.println("UsuarioDAO_Result: --> " + objUser.getId());
			
		} catch (Exception e) {
			System.out.println("ErrorUsuarioDAO: --> " + e.getMessage());
		} finally {
			cerrar();
		}
		return objUser;
	}

	@Override
	public boolean RegistrarUsuario(UsuarioJPA usuario) throws Exception {
		boolean res = false;

		try {
			abrir();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			res = true;
		} catch (Exception e) {
			System.out.println("ErrorUsuarioDAO: --> " + e.getMessage());
			em.getTransaction().rollback();
		} finally {
			cerrar();
		}
		return res;
	}

	@Override
	public boolean ActualizarUsuario(UsuarioJPA usuario) throws Exception {
		boolean res = false;

		try {
			abrir();
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
			res = true;

		} catch (Exception e) {
			System.out.println("ErrorUsuarioDAO: --> " + e.getMessage());
			em.getTransaction().rollback();
		} finally {
			cerrar();
		}

		return res;
	}

	@Override
	public boolean EliminarUsuario(UsuarioJPA usuario) throws Exception {
		boolean res = false;
		UsuarioJPA usuarioJpa = null;

		try {
			abrir();
			usuarioJpa = em.find(UsuarioJPA.class, usuario.getId());

			if (usuarioJpa != null) {
				em.getTransaction().begin();
				em.remove(usuarioJpa);
				em.getTransaction().commit();
				res = true;
			}

		} catch (Exception e) {
			System.out.println("ErrorUsuarioDAO: --> " + e.getMessage());
			em.getTransaction().rollback();
		} finally {
			cerrar();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioJPA> ListarUsuarios(UsuarioJPA usuario) throws Exception {

		List<UsuarioJPA> lista = null;

		try {
			abrir();

			Query res = em.createQuery("Select u from UsuarioJPA u");
			lista = res.getResultList();

		} catch (Exception e) {
			System.out.println("ErrorUsuarioDAO: --> " + e.getMessage());
		} finally {
			cerrar();
		}
		return lista;
	}

}
