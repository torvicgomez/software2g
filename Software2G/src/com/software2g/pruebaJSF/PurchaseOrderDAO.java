package com.software2g.pruebaJSF;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Tipoespecialidad;

@Stateless
@LocalBean
public class PurchaseOrderDAO {
	@PersistenceContext
	EntityManager em;

	public void crear(Tipoespecialidad pedido) {
		em.persist(pedido);
	}

	public void actualizar(Tipoespecialidad pedido) {
		em.merge(pedido);
	}

	public void borrar(Tipoespecialidad pedido) {
		em.remove(pedido);
	}
	
	public Tipoespecialidad buscarPorID(Long id) {
		return (em.find(Tipoespecialidad.class, id));
	}

	public List<Tipoespecialidad> buscarTodos() {
		Query q = em.createQuery("SELECT p FROM \"HISCLINICA\".\"TIPOESPECIALIDAD\" p");
		return q.getResultList();
	}

	public List<Tipoespecialidad> buscarPorCliente(long idCliente) {
		Query q = em.createQuery("SELECT p FROM \"HISCLINICA\".\"TIPOESPECIALIDAD\" p WHERE p.tiesId = :idCliente");
		q.setParameter("idCliente", idCliente);
		return q.getResultList();
	}
}
