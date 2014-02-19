package com.software2g.portal.facade.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.portal.dao.IAplicacionDao;
import com.software2g.portal.dao.IDepartamentoDao;
import com.software2g.portal.dao.IFuncionalidadDao;
import com.software2g.portal.dao.IFuncionalidadRolDao;
import com.software2g.portal.dao.IInstitucionDao;
import com.software2g.portal.dao.IMunicipioDao;
import com.software2g.portal.dao.IPaisDao;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.portal.dao.IPersonaInstitucionDao;
import com.software2g.portal.dao.IRolDao;
import com.software2g.portal.dao.IRolUsuarioDao;
import com.software2g.portal.dao.ITipoDocumentoDao;
import com.software2g.portal.dao.IUsuarioDao;
import com.software2g.portal.facade.IGestionFacadePortal;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.vo.Aplicacion;
import com.software2g.vo.Departamento;
import com.software2g.vo.Funcionalidad;
import com.software2g.vo.Funcionalidadrol;
import com.software2g.vo.Institucion;
import com.software2g.vo.Municipio;
import com.software2g.vo.Pais;
import com.software2g.vo.Persona;
import com.software2g.vo.Personainstitucion;
import com.software2g.vo.Rol;
import com.software2g.vo.Rolusuario;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Usuario;

@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadePortalSpringService implements IGestionFacadePortal{
	@Autowired
	IAplicacionDao aplicacionDao;
	@Autowired
	IFuncionalidadDao funcionalidadDao;
	@Autowired
	IFuncionalidadRolDao funcionalidadRolDao;
	@Autowired
	IInstitucionDao institucionDao;
	@Autowired
	IPersonaDao personaDao;
	@Autowired
	IPersonaInstitucionDao personaInstitucionDao;
	@Autowired
	IRolDao rolDao;
	@Autowired
	IRolUsuarioDao rolUsuarioDao;
	@Autowired
	ITipoDocumentoDao tipoDocumentoDao;
	@Autowired
	IUsuarioDao usuarioDao;
	@Autowired
	IPaisDao paisDao;
	@Autowired
	IDepartamentoDao departamentoDao;
	@Autowired
	IMunicipioDao municipioDao;
	
	public IAplicacionDao getAplicacionDao() {return aplicacionDao;}
	public void setAplicacionDao(IAplicacionDao aplicacionDao) {this.aplicacionDao = aplicacionDao;}
	public IFuncionalidadDao getFuncionalidadDao() {return funcionalidadDao;}
	public void setFuncionalidadDao(IFuncionalidadDao funcionalidadDao) {this.funcionalidadDao = funcionalidadDao;}
	public IFuncionalidadRolDao getFuncionalidadRolDao() {return funcionalidadRolDao;}
	public void setFuncionalidadRolDao(IFuncionalidadRolDao funcionalidadRolDao) {this.funcionalidadRolDao = funcionalidadRolDao;}
	public IInstitucionDao getInstitucionDao() {return institucionDao;}
	public void setInstitucionDao(IInstitucionDao institucionDao) {this.institucionDao = institucionDao;}
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	public IPersonaInstitucionDao getPersonaInstitucionDao() {return personaInstitucionDao;}
	public void setPersonaInstitucionDao(IPersonaInstitucionDao personaInstitucionDao) {this.personaInstitucionDao = personaInstitucionDao;}
	public IRolDao getRolDao() {return rolDao;}
	public void setRolDao(IRolDao rolDao) {this.rolDao = rolDao;}
	public IRolUsuarioDao getRolUsuarioDao() {return rolUsuarioDao;}
	public void setRolUsuarioDao(IRolUsuarioDao rolUsuarioDao) {this.rolUsuarioDao = rolUsuarioDao;}
	public ITipoDocumentoDao getTipoDocumentoDao() {return tipoDocumentoDao;}
	public void setTipoDocumentoDao(ITipoDocumentoDao tipoDocumentoDao) {this.tipoDocumentoDao = tipoDocumentoDao;}
	public IUsuarioDao getUsuarioDao() {return usuarioDao;}
	public void setUsuarioDao(IUsuarioDao usuarioDao) {this.usuarioDao = usuarioDao;}
	public IPaisDao getPaisDao() {return paisDao;}
	public void setPaisDao(IPaisDao paisDao) {this.paisDao = paisDao;}
	public IDepartamentoDao getDepartamentoDao() {return departamentoDao;}
	public void setDepartamentoDao(IDepartamentoDao departamentoDao) {this.departamentoDao = departamentoDao;}
	public IMunicipioDao getMunicipioDao() {return municipioDao;}
	public void setMunicipioDao(IMunicipioDao municipioDao) {this.municipioDao = municipioDao;}
	
	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad Aplicacion
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Aplicacion findAplicacionById(java.lang.Integer id) throws Exception {
		try {
			return getAplicacionDao().findAplicacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findAplicacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Aplicacion> findAllAplicacions() throws Exception {
		try {
			return getAplicacionDao().findAllAplicacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllAplicacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAplicacion(Aplicacion aplicacion) throws Exception {
		try {
			getAplicacionDao().persistAplicacion(aplicacion);
		} catch (RuntimeException e) {
			throw new Exception("persistAplicacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAplicacion(Aplicacion aplicacion) throws Exception {
		try {
			getAplicacionDao().removeAplicacion(aplicacion);
		} catch (RuntimeException e) {
			throw new Exception("removeAplicacion failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad Aplicacion
	//-------------------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad FuncionalidadRol
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Funcionalidadrol findFuncionalidadrolById(com.software2g.vo.FuncionalidadrolPK id) throws Exception {
		try {
			return getFuncionalidadRolDao().findFuncionalidadrolById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFuncionalidadrolById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Funcionalidadrol</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Funcionalidadrol> findAllFuncionalidadrols() throws Exception {
		try {
			return getFuncionalidadRolDao().findAllFuncionalidadrols();
		} catch (RuntimeException e) {
			throw new Exception("findAllFuncionalidadrols failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFuncionalidadrol(Funcionalidadrol funcionalidadrol) throws Exception {
		try {
			getFuncionalidadRolDao().persistFuncionalidadrol(funcionalidadrol);
		} catch (RuntimeException e) {
			throw new Exception("persistFuncionalidadrol failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFuncionalidadrol(Funcionalidadrol funcionalidadrol) throws Exception {
		try {
			getFuncionalidadRolDao().removeFuncionalidadrol(funcionalidadrol);
		} catch (RuntimeException e) {
			throw new Exception("removeFuncionalidadrol failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad FuncionalidadRol
	//Metodos propios
	/**
	 * Metodo que obtiene las funcionalidades asociadas a un rol en especifico. 
	 * @param idRol
	 * @return
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Funcionalidadrol> findAllFuncionalidadrols(Integer idRol) throws Exception{
		try {
			return getFuncionalidadRolDao().findAllFuncionalidadrols(idRol);
		} catch (RuntimeException e) {
			throw new Exception("findAllFuncionalidadrols failed: " + e.getMessage());
		}
	}
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad Funcionalidad
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Funcionalidad findFuncionalidadById(java.lang.Integer id) throws Exception {
		try {
			return getFuncionalidadDao().findFuncionalidadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFuncionalidadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Funcionalidad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Funcionalidad> findAllFuncionalidads() throws Exception {
		try {
			return getFuncionalidadDao().findAllFuncionalidads();
		} catch (RuntimeException e) {
			throw new Exception("findAllFuncionalidads failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFuncionalidad(Funcionalidad funcionalidad) throws Exception {
		try {
			getFuncionalidadDao().persistFuncionalidad(funcionalidad);
		} catch (RuntimeException e) {
			//throw new Exception("persistFuncionalidad failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFuncionalidad(Funcionalidad funcionalidad) throws Exception {
		try {
			getFuncionalidadDao().removeFuncionalidad(funcionalidad);
		} catch (RuntimeException e) {
			throw new Exception("removeFuncionalidad failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad Funcionalidad
	//-------------------------------------------------------------------------------------
	
	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad Institucion
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Institucion findInstitucionById(java.lang.Integer id) throws Exception {
		try {
			return getInstitucionDao().findInstitucionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findInstitucionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Institucion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Institucion> findAllInstitucions() throws Exception {
		try {
			return getInstitucionDao().findAllInstitucions();
		} catch (RuntimeException e) {
			throw new Exception("findAllInstitucions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistInstitucion(Institucion institucion) throws Exception {
		try {
			getInstitucionDao().persistInstitucion(institucion);
		} catch (RuntimeException e) {
			throw new Exception("persistInstitucion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeInstitucion(Institucion institucion) throws Exception {
		try {
			getInstitucionDao().removeInstitucion(institucion);
		} catch (RuntimeException e) {
			throw new Exception("removeInstitucion failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad Institucion
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad PersonaInstitucion
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Personainstitucion findPersonainstitucionById(com.software2g.vo.PersonainstitucionPK id) throws Exception {
		try {
			return getPersonaInstitucionDao().findPersonainstitucionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonainstitucionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Personainstitucion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Personainstitucion> findAllPersonainstitucions() throws Exception {
		try {
			return getPersonaInstitucionDao().findAllPersonainstitucions();
		} catch (RuntimeException e) {
			throw new Exception("findAllPersonainstitucions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonainstitucion(Personainstitucion personainstitucion) throws Exception {
		try {
			getPersonaInstitucionDao().persistPersonainstitucion(personainstitucion);
		} catch (RuntimeException e) {
			throw new Exception("persistPersonainstitucion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonainstitucion(Personainstitucion personainstitucion) throws Exception {
		try {
			getPersonaInstitucionDao().removePersonainstitucion(personainstitucion);
		} catch (RuntimeException e) {
			throw new Exception("removePersonainstitucion failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad PersonaInstitucion
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad Persona
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Persona findPersonaById(java.lang.Integer id) throws Exception {
		try {
			return getPersonaDao().findPersonaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Persona</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Persona> findAllPersonas() throws Exception {
		try {
			return getPersonaDao().findAllPersonas();
		} catch (RuntimeException e) {
			throw new Exception("findAllPersonas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersona(Persona persona) throws Exception {
		try {
			getPersonaDao().persistPersona(persona);
		} catch (RuntimeException e) {
			throw new Exception("persistPersona failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersona(Persona persona) throws Exception {
		try {
			getPersonaDao().removePersona(persona);
		} catch (RuntimeException e) {
			throw new Exception("removePersona failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad Persona
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad Rol
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Rol findRolById(Integer id) throws Exception {
		try {
			return getRolDao().findRolById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRolById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Rol</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Rol> findAllRols() throws Exception {
		try {
			return getRolDao().findAllRols();
		} catch (RuntimeException e) {
			throw new Exception("findAllRols failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRol(Rol rol) throws Exception {
		try {
			getRolDao().persistRol(rol);
		} catch (RuntimeException e) {
			throw new Exception("persistRol failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRol(Rol rol) throws Exception {
		try {
			getRolDao().removeRol(rol);
		} catch (RuntimeException e) {
			throw new Exception("removeRol failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad Rol
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad RolUsuario
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Rolusuario findRolusuarioById(com.software2g.vo.RolusuarioPK id) throws Exception {
		try {
			return getRolUsuarioDao().findRolusuarioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRolusuarioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Rolusuario</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Rolusuario> findAllRolusuarios() throws Exception {
		try {
			return getRolUsuarioDao().findAllRolusuarios();
		} catch (RuntimeException e) {
			throw new Exception("findAllRolusuarios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRolusuario(Rolusuario rolusuario) throws Exception {
		try {
			getRolUsuarioDao().persistRolusuario(rolusuario);
		} catch (RuntimeException e) {
			throw new Exception("persistRolusuario failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRolusuario(Rolusuario rolusuario) throws Exception {
		try {
			getRolUsuarioDao().removeRolusuario(rolusuario);
		} catch (RuntimeException e) {
			throw new Exception("removeRolusuario failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad RolUsuario

	// Metodos propios
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Rolusuario> findAllRolusuarios(String login) throws Exception{
		try {
			return getRolUsuarioDao().findAllRolusuarios(login);
		} catch (RuntimeException e) {
			throw new Exception("findAllRolusuarios login " + login + " failed: " + e.getMessage());
		}
	}
	
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad TipoDocumento
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception {
		try {
			return getTipoDocumentoDao().findTipodocumentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodocumentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodocumento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodocumento> findAllTipodocumentos() throws Exception {
		try {
			System.out.println("Entra esta parte de implementacion del mentodo: [List<Tipodocumento> findAllTipodocumentos()]!!!!!!!!!!!");
			List<Tipodocumento> lista = getTipoDocumentoDao().findAllTipodocumentos();
			return lista;
		} catch (Exception ee){
			System.out.println("metod de la GestionFacadePortalSpringService !!!!!!!!!!!!!");
			ee.printStackTrace();
		}/* catch (RuntimeException e) {
			throw new Exception("findAllTipodocumentos failed: " + e.getMessage());
		}*/
		return null;
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception {
		try {
			getTipoDocumentoDao().persistTipodocumento(tipodocumento);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodocumento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception {
		try {
			getTipoDocumentoDao().removeTipodocumento(tipodocumento);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodocumento failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad TipoDocumento
	//-------------------------------------------------------------------------------------

	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad Usuario
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Usuario findUsuarioById(java.lang.String id) throws Exception {
		try {
			return getUsuarioDao().findUsuarioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUsuarioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Usuario</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Usuario> findAllUsuarios() throws Exception {
		try {
			return getUsuarioDao().findAllUsuarios();
		} catch (RuntimeException e) {
			throw new Exception("findAllUsuarios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUsuario(Usuario usuario) throws Exception {
		try {
			getUsuarioDao().persistUsuario(usuario);
		} catch (RuntimeException e) {
			throw new Exception("persistUsuario failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUsuario(Usuario usuario) throws Exception {
		try {
			getUsuarioDao().removeUsuario(usuario);
		} catch (RuntimeException e) {
			throw new Exception("removeUsuario failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad Usuario
	
	//Metodos propios
	/**
	 * Metodo de busqueda de usuario segun estado y login
	 * @param login
	 * @param estado
	 * @return
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Usuario findUsuarioById(String login, String password, String estado) throws Exception {
		try {
			return getUsuarioDao().findUsuarioById(login,password,estado);
		} catch (RuntimeException e) {
			//e.printStackTrace();
			//throw new Exception("findUsuarioById failed with the login " + login + " and estado " + estado + " : " + e.getMessage());
			return null;
		}
	}
	//-------------------------------------------------------------------------------------

	//-----------------------------------------------------------------------------------
	// Metodos de la logica del negocio													-
	//-----------------------------------------------------------------------------------
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Usuario cargarPortalUser(Usuario usuarioVO, String estado) throws Exception{
		String password = usuarioVO.getPasswordUsua();
		System.out.println("password: ["+password+"]");
		Usuario userLogin = findUsuarioById(usuarioVO.getLoginUsua(),usuarioVO.getPasswordUsua(),estado);
		if(userLogin!=null){
			System.out.println("Entra esta parte *****************+");
			if(userLogin.getPasswordUsua().equals(password)){
				//Cargar roles y las funcionalidades asociadas al cada rol
				System.out.println("En Construccion!!!!!!");
				userLogin.setRolusuarios(findAllRolusuarios(userLogin.getLoginUsua()));
				if(userLogin.getRolusuarios()!=null&&userLogin.getRolusuarios().size()>0){
					for(Rolusuario elem:userLogin.getRolusuarios())
						elem.getRol().setFuncionalidadrols(findAllFuncionalidadrols(elem.getRol().getIdRol()));
				}
			}else
				System.out.println("Contraseña usuario no coincide!!!");
		}else
			System.out.println("Error usuario no existe en BD!!!");
		return userLogin;
	}
	
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Pais findPaisById(long id) throws Exception {
		try {
			return getPaisDao().findPaisById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPaisById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pais> findAllPaiss() throws Exception {
		try {
			return getPaisDao().findAllPaiss();
		} catch (RuntimeException e) {
			throw new Exception("findAllPaiss failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Departamento findDepartamentoById(long id) throws Exception {
		try {
			return getDepartamentoDao().findDepartamentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDepartamentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Departamento> findAllDepartamentos() throws Exception {
		try {
			return getDepartamentoDao().findAllDepartamentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllDepartamentos failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Municipio findMunicipioById(long id) throws Exception {
		try {
			return getMunicipioDao().findMunicipioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findMunicipioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Municipio> findAllMunicipios() throws Exception {
		try {
			return getMunicipioDao().findAllMunicipios();
		} catch (RuntimeException e) {
			throw new Exception("findAllMunicipios failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Municipio> findAllMunicipios(long idDpto) throws Exception {
		try {
			return getMunicipioDao().findAllMunicipios(idDpto);
		} catch (RuntimeException e) {
			throw new Exception("findAllMunicipios failed: " + e.getMessage());
		}
	}
	
	public List<Funcionalidad> getFunctionApplication(String funcIdPadre, String funcId, long rolId) throws Exception {
		try {
			return getFuncionalidadDao().getFunctionApplication(funcIdPadre, funcId, rolId);
		} catch (RuntimeException e) {
			//throw new Exception("getFunctionApplication failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean crearFile(String path, String nameFile, String ext, String tipoFile) throws Exception{
		boolean result = false;
		try {
			System.out.println("archivo: ["+path+nameFile+ext+"]");
			File file = new File(path+nameFile+ext);
			if(file.exists())
				file.delete();
			System.out.println("Continua!!!!!!!");
			FileWriter createFile = new FileWriter(path+nameFile+ext);
			System.out.println("tipo file: ["+tipoFile+"]");
			if(tipoFile.equals(ConstantesAplicativo.constanteTipoFileJSFuncRol)){
				result = this.crearJSFileFunctionRol(createFile);
			}
			createFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private boolean crearJSFileFunctionRol(FileWriter file) throws Exception{
		boolean result = false;
		try {
			List<Funcionalidad> list = getFunctionApplication(null, null, 1);
			if(list!=null&&list.size()>0){
				String nodo = imprimirListaFunction(list);
				nodo = "var zNodesRol =["+(nodo.substring(0,nodo.lastIndexOf(",")))+"];";
				System.out.println("*******************************************");
				System.out.println("*******************************************");
				System.out.println("nodos:"+nodo);
				System.out.println("*******************************************");
				System.out.println("*******************************************");
				file.write(nodo);
				result = true;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
	private String imprimirListaFunction(List<Funcionalidad> list){
		String nodo = "";
		if(list!=null&&list.size()>0){
			for(Funcionalidad elem:list){
				System.out.println("funcion Etiqueta: ["+elem.getEtiquetaFunc()+"]");
				nodo += "{id:"+elem.getIdFunc()+", pId:"+(elem.getFuncionalidad()!=null&&elem.getFuncionalidad().getIdFunc()>0?elem.getFuncionalidad().getIdFunc():"0")+"" +
						", name:\"["+elem.getEtiquetaFunc()+"] - "+elem.getNombreFunc()+"\", checked:"+(elem.getChecked().equals("S")?"true":"false")+"" +
						" "+(elem.getFuncionalidads()!=null&&elem.getFuncionalidads().size()>0?", open:true":"")+"" +
						" "+(elem.getEstadoFunc().equals(ConstantesAplicativo.constanteEstadoInactivo)?", chkDisabled:true, font:{'color':'red'}":"")+"}, \n";
				if(elem.getFuncionalidads()!=null&&elem.getFuncionalidads().size()>0)
					nodo += imprimirListaFunction(elem.getFuncionalidads());
			}
		}
		return nodo;
	}
	
}

