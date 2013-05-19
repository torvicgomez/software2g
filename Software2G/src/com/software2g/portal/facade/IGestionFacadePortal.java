package com.software2g.portal.facade;

import java.util.List;

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

public interface IGestionFacadePortal {
	//--------------------------------------------------------------------------
	//Metodos Entidad Aplicacion
	public Aplicacion findAplicacionById(java.lang.Integer id) throws Exception;
	public List<Aplicacion> findAllAplicacions() throws Exception;
	public void persistAplicacion(Aplicacion aplicacion) throws Exception;
	public void removeAplicacion(Aplicacion aplicacion) throws Exception;
	//FIN --- Metodos Entidad Aplicacion
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad FuncionalidadRol
	public Funcionalidadrol findFuncionalidadrolById(com.software2g.vo.FuncionalidadrolPK id) throws Exception;
	public List<Funcionalidadrol> findAllFuncionalidadrols() throws Exception;
	public void persistFuncionalidadrol(Funcionalidadrol funcionalidadrol) throws Exception;
	public void removeFuncionalidadrol(Funcionalidadrol funcionalidadrol) throws Exception;
	//FIN --- Metodos Entidad FuncionalidadRol
	//Metodos propios
	/**
	 * Metodo que obtiene las funcionalidades asociadas a un rol en especifico. 
	 * @param idRol
	 * @return
	 */
	public List<Funcionalidadrol> findAllFuncionalidadrols(Integer idRol) throws Exception;
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Funcionalidad
	public Funcionalidad findFuncionalidadById(java.lang.Integer id) throws Exception;
	public List<Funcionalidad> findAllFuncionalidads() throws Exception;
	public void persistFuncionalidad(Funcionalidad funcionalidad) throws Exception;
	public void removeFuncionalidad(Funcionalidad funcionalidad) throws Exception;
	//FIN --- Metodos Entidad Funcionalidad
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Institucion
	public Institucion findInstitucionById(java.lang.Integer id) throws Exception;
	public List<Institucion> findAllInstitucions() throws Exception;
	public void persistInstitucion(Institucion institucion) throws Exception;
	public void removeInstitucion(Institucion institucion) throws Exception;
	//FIN --- Metodos Entidad Institucion
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad PersonaInstitucion
	public Personainstitucion findPersonainstitucionById(com.software2g.vo.PersonainstitucionPK id) throws Exception;
	public List<Personainstitucion> findAllPersonainstitucions() throws Exception;
	public void persistPersonainstitucion(Personainstitucion personainstitucion) throws Exception;
	public void removePersonainstitucion(Personainstitucion personainstitucion) throws Exception;
	//FIN --- Metodos Entidad PersonaInstitucion
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Persona
	public Persona findPersonaById(java.lang.Integer id) throws Exception;
	public List<Persona> findAllPersonas() throws Exception;
	public void persistPersona(Persona persona) throws Exception;
	public void removePersona(Persona persona) throws Exception;
	//FIN --- Metodos Entidad Persona
	//--------------------------------------------------------------------------
		
	//--------------------------------------------------------------------------
	//Metodos Entidad Rol
	public Rol findRolById(java.lang.Integer id) throws Exception;
	public List<Rol> findAllRols() throws Exception;
	public void persistRol(Rol rol) throws Exception;
	public void removeRol(Rol rol) throws Exception;
	//FIN --- Metodos Entidad Rol
	//--------------------------------------------------------------------------	
	
	//--------------------------------------------------------------------------
	//Metodos Entidad RolUsuario
	public Rolusuario findRolusuarioById(com.software2g.vo.RolusuarioPK id) throws Exception;
	public List<Rolusuario> findAllRolusuarios() throws Exception;
	public void persistRolusuario(Rolusuario rolusuario) throws Exception;
	public void removeRolusuario(Rolusuario rolusuario) throws Exception;
	//FIN --- Metodos Entidad RolUsuario
	//Metodos propios
	/**
	 * Meotodo que obtine los roles asociados a un respectivo usuario
	 * @param login
	 * @return
	 */
	public List<Rolusuario> findAllRolusuarios(String login) throws Exception;
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad TipoDocumento
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception;
	public List<Tipodocumento> findAllTipodocumentos() throws Exception;
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception;
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception;
	//FIN --- Metodos Entidad TipoDocumento
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Usuario
	public Usuario findUsuarioById(java.lang.String id) throws Exception;
	public List<Usuario> findAllUsuarios() throws Exception;
	public void persistUsuario(Usuario usuario) throws Exception;
	public void removeUsuario(Usuario usuario) throws Exception;
	//FIN --- Metodos Entidad Usuario
	//Metodos propios
	/**
	 * Metodo de busqueda de usuario segun estado y login
	 * @param login
	 * @param estado
	 * @return
	 */
	public Usuario findUsuarioById(String login, String pasword, String estado) throws Exception;
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Negocio
	public Usuario cargarPortalUser(Usuario usuarioVO, String estado) throws Exception;
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Pais
	public Pais findPaisById(long id) throws Exception;
	public List<Pais> findAllPaiss() throws Exception;
	//FIN --- Metodos Entidad Pais
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Departamento
	public Departamento findDepartamentoById(long id) throws Exception;
	public List<Departamento> findAllDepartamentos() throws Exception;
	//FIN --- Metodos Entidad Departamento
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Municipio
	public Municipio findMunicipioById(long id) throws Exception;
	public List<Municipio> findAllMunicipios() throws Exception;
	public List<Municipio> findAllMunicipios(long idDpto) throws Exception;
	//FIN --- Metodos Entidad Municipio
	//--------------------------------------------------------------------------
	
}
