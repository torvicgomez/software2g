package com.software2g.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.IUsuarioDao;
import com.software2g.vo.Usuario;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Usuario entity.
 */
@Repository
public class UsuarioDaoImpl implements IUsuarioDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public UsuarioDaoImpl() {
		super();
	}
	/**
	 * Return the persistent entities returned from a named query.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName) {
		Query queryObject = em.createNamedQuery(queryName);
		return queryObject.getResultList();
	}
	/**
	 * Return the persistent entities returned from a named query with named parameters.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName, String[] paramNames, Object[] paramValues) {
		if (paramNames.length != paramValues.length) {
			throw new IllegalArgumentException();
		}
		Map<String, Object> params = new java.util.HashMap<String, Object>(paramNames.length);
		for (int i = 0; i < paramNames.length; ++i) {
			params.put(paramNames[i], paramValues[i]);
		}
		
		Query queryObject = em.createNamedQuery(queryName);
		if (params != null) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				queryObject.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return queryObject.getResultList();

	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Usuario findUsuarioById(java.lang.String id) {
		return (Usuario)em.find(Usuario.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Usuario</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {
        try {
    		String jpqlString = "select usuario from " + Usuario.class.getSimpleName() + " usuario";
            Query query = em.createQuery( jpqlString );
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUsuario(Usuario usuario) {
		em.persist(em.merge(usuario));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUsuario(Usuario usuario) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(usuario));
	}
	
	
	//***********************************************************************
	//* Query Nativos														*
	//***********************************************************************
	/**
	 * Metodo de busquedad de usuario segun su estado y login
	 */
	public Usuario findUsuarioById(String login, String password, String estado) {
		try {
			String jpqlString = "select usuario from " + Usuario.class.getSimpleName() + " usuario " +
					" where usuario.loginUsua = :login " +
					" and usuario.passwordUsua = :password " +
					" and usuario.estadoUsua = :estado ";
        	Query query = em.createQuery( jpqlString );
        	query.setParameter("login", login);
        	query.setParameter("password", password);
        	query.setParameter("estado", estado);
            return (Usuario)query.getSingleResult();
        }finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}