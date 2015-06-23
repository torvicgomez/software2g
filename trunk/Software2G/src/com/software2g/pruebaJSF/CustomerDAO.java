package com.software2g.pruebaJSF;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Procedimiento;
import com.software2g.vo.Tipoprocedimiento;

@Stateless
@LocalBean
public class CustomerDAO {
	
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
	EntityManager em;
	
	public void crear(Procedimiento cliente) {
		em.persist(cliente);
	}
	
	public void actualizar(Procedimiento cliente) {
		em.merge(cliente);
	}
	
	public void borrar(Procedimiento cliente) {
		em.remove(cliente);
	}
	
	public Procedimiento buscarPorID(Long id) {
		return (em.find(Procedimiento.class, id));
	}
	
	public List<Procedimiento> buscarTodos() {
		Query q = em.createQuery("SELECT c FROM \"HISCLINICA\".\"PROCEDIMIENTOS\" c");
		return q.getResultList();
	}
	
	public List<Procedimiento> buscarPorNombre(String nombre) {
		Query q = em.createQuery("SELECT c FROM \"HISCLINICA\".\"PROCEDIMIENTOS\" c WHERE c.prtoNombre LIKE :patron");
		q.setParameter("patron", "%" + nombre + "%");
		return q.getResultList();
	}

	public List<Tipoprocedimiento> listaCodigosDescuento(){
		Query q = em.createQuery("SELECT cd FROM \"HISCLINICA\".\"TIPOPROCEDIMIENTO\" cd");
		return q.getResultList();
	}
}