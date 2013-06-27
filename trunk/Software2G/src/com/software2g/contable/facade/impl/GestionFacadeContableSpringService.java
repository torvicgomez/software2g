package com.software2g.contable.facade.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.contable.dao.IAbonoDao;
import com.software2g.contable.dao.ICreditoDao;
import com.software2g.contable.dao.ICreditoTipoDescuentoDao;
import com.software2g.contable.dao.IDonacionDao;
import com.software2g.contable.dao.IDonacionObjetoDao;
import com.software2g.contable.dao.IDonacionSucursalDao;
import com.software2g.contable.dao.IEntidadDonanteDao;
import com.software2g.contable.dao.IObjetoDao;
import com.software2g.contable.dao.IPagareDao;
import com.software2g.contable.dao.IPresupuestoDao;
import com.software2g.contable.dao.IPresupuestoDonacionDao;
import com.software2g.contable.dao.IPresupuestoSucursalDao;
import com.software2g.contable.dao.ISeguroDao;
import com.software2g.contable.dao.ISucursalDao;
import com.software2g.contable.dao.ITipoCreditoDao;
import com.software2g.contable.dao.ITipoCreditoSeguroAdquiridoDao;
import com.software2g.contable.dao.ITipoDescuentoDao;
import com.software2g.contable.dao.ITipoPagareDao;
import com.software2g.contable.facade.IGestionFacadeContable;
import com.software2g.portal.dao.IDepartamentoDao;
import com.software2g.portal.dao.IMunicipioDao;
import com.software2g.portal.dao.IPaisDao;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.portal.dao.ITipoDocumentoDao;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Abono;
import com.software2g.vo.Credito;
import com.software2g.vo.Creditotipodescuento;
import com.software2g.vo.Departamento;
import com.software2g.vo.Donacion;
import com.software2g.vo.Donacionobjeto;
import com.software2g.vo.Donacionsucursal;
import com.software2g.vo.Entidaddonante;
import com.software2g.vo.Municipio;
import com.software2g.vo.Objeto;
import com.software2g.vo.Pagare;
import com.software2g.vo.Pais;
import com.software2g.vo.Persona;
import com.software2g.vo.Presupuesto;
import com.software2g.vo.Presupuestodonacion;
import com.software2g.vo.Presupuestosucursal;
import com.software2g.vo.Seguro;
import com.software2g.vo.Sucursal;
import com.software2g.vo.Tipocredito;
import com.software2g.vo.Tipocreditoseguroadquirido;
import com.software2g.vo.Tipodescuento;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Tipopagare;



@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadeContableSpringService implements IGestionFacadeContable{
	@Autowired
	IAbonoDao abonoDao;
	@Autowired
	ICreditoDao creditoDao;
	@Autowired
	ICreditoTipoDescuentoDao creditoTipoDesDao;
	@Autowired
	IDonacionDao donacionDao;
	@Autowired
	IDonacionObjetoDao donacionObjDao;
	@Autowired
	IDonacionSucursalDao donacionSucursalDao;
	@Autowired
	IEntidadDonanteDao entidadDonanteDao;
	@Autowired
	IObjetoDao objetoDao;
	@Autowired
	IPagareDao pagareDao;
	@Autowired
	IPresupuestoDao presupuestoDao;
	@Autowired
	IPresupuestoDonacionDao presupuestoDonacionDao;
	@Autowired
	IPresupuestoSucursalDao presupuestoSucursalDao;
	@Autowired
	ISeguroDao seguroDao;
	@Autowired
	ISucursalDao sucursalDao;
	@Autowired
	ITipoCreditoDao tipoCreditoDao;
	@Autowired
	ITipoCreditoSeguroAdquiridoDao tipoCreSegAdquiridoDao;
	@Autowired
	ITipoDescuentoDao tipoDescuentoDao;
	@Autowired
	ITipoPagareDao tipoPagareDao;
	@Autowired
	IPersonaDao personaDao;
	@Autowired
	ITipoDocumentoDao tipoDocumentoDao;
	@Autowired
	IPaisDao paisDao;
	@Autowired
	IDepartamentoDao departamentoDao;
	@Autowired
	IMunicipioDao municipioDao;
	
	public IAbonoDao getAbonoDao() {return abonoDao;}
	public void setAbonoDao(IAbonoDao abonoDao) {this.abonoDao = abonoDao;}
	public ICreditoDao getCreditoDao() {return creditoDao;}
	public void setCreditoDao(ICreditoDao creditoDao) {this.creditoDao = creditoDao;}
	public ICreditoTipoDescuentoDao getCreditoTipoDesDao() {return creditoTipoDesDao;}
	public void setCreditoTipoDesDao(ICreditoTipoDescuentoDao creditoTipoDesDao) {this.creditoTipoDesDao = creditoTipoDesDao;}
	public IDonacionDao getDonacionDao() {return donacionDao;}
	public void setDonacionDao(IDonacionDao donacionDao) {this.donacionDao = donacionDao;}
	public IDonacionObjetoDao getDonacionObjDao() {return donacionObjDao;}
	public void setDonacionObjDao(IDonacionObjetoDao donacionObjDao) {this.donacionObjDao = donacionObjDao;}
	public IDonacionSucursalDao getDonacionSucursalDao() {return donacionSucursalDao;}
	public void setDonacionSucursalDao(IDonacionSucursalDao donacionSucursalDao) {this.donacionSucursalDao = donacionSucursalDao;}
	public IEntidadDonanteDao getEntidadDonanteDao() {return entidadDonanteDao;}
	public void setEntidadDonanteDao(IEntidadDonanteDao entidadDonanteDao) {this.entidadDonanteDao = entidadDonanteDao;}
	public IObjetoDao getObjetoDao() {return objetoDao;}
	public void setObjetoDao(IObjetoDao objetoDao) {this.objetoDao = objetoDao;}
	public IPagareDao getPagareDao() {return pagareDao;}
	public void setPagareDao(IPagareDao pagareDao) {this.pagareDao = pagareDao;}
	public IPresupuestoDao getPresupuestoDao() {return presupuestoDao;}
	public void setPresupuestoDao(IPresupuestoDao presupuestoDao) {this.presupuestoDao = presupuestoDao;}
	public IPresupuestoDonacionDao getPresupuestoDonacionDao() {return presupuestoDonacionDao;}
	public void setPresupuestoDonacionDao(IPresupuestoDonacionDao presupuestoDonacionDao) {this.presupuestoDonacionDao = presupuestoDonacionDao;}
	public IPresupuestoSucursalDao getPresupuestoSucursalDao() {return presupuestoSucursalDao;}
	public void setPresupuestoSucursalDao(IPresupuestoSucursalDao presupuestoSucursalDao) {this.presupuestoSucursalDao = presupuestoSucursalDao;}
	public ISeguroDao getSeguroDao() {return seguroDao;}
	public void setSeguroDao(ISeguroDao seguroDao) {this.seguroDao = seguroDao;}
	public ISucursalDao getSucursalDao() {return sucursalDao;}
	public void setSucursalDao(ISucursalDao sucursalDao) {this.sucursalDao = sucursalDao;}
	public ITipoCreditoDao getTipoCreditoDao() {return tipoCreditoDao;}
	public void setTipoCreditoDao(ITipoCreditoDao tipoCreditoDao) {this.tipoCreditoDao = tipoCreditoDao;}
	public ITipoDescuentoDao getTipoDescuentoDao() {return tipoDescuentoDao;}
	public void setTipoDescuentoDao(ITipoDescuentoDao tipoDescuentoDao) {this.tipoDescuentoDao = tipoDescuentoDao;}
	public ITipoPagareDao getTipoPagareDao() {return tipoPagareDao;}
	public void setTipoPagareDao(ITipoPagareDao tipoPagareDao) {this.tipoPagareDao = tipoPagareDao;}
	public ITipoCreditoSeguroAdquiridoDao getTipoCreSegAdquiridoDao() {return tipoCreSegAdquiridoDao;}
	public void setTipoCreSegAdquiridoDao(ITipoCreditoSeguroAdquiridoDao tipoCreSegAdquiridoDao) {this.tipoCreSegAdquiridoDao = tipoCreSegAdquiridoDao;}
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	public ITipoDocumentoDao getTipoDocumentoDao() {return tipoDocumentoDao;}
	public void setTipoDocumentoDao(ITipoDocumentoDao tipoDocumentoDao) {this.tipoDocumentoDao = tipoDocumentoDao;}
	public IPaisDao getPaisDao() {return paisDao;}
	public void setPaisDao(IPaisDao paisDao) {this.paisDao = paisDao;}
	public IDepartamentoDao getDepartamentoDao() {return departamentoDao;}
	public void setDepartamentoDao(IDepartamentoDao departamentoDao) {this.departamentoDao = departamentoDao;}
	public IMunicipioDao getMunicipioDao() {return municipioDao;}
	public void setMunicipioDao(IMunicipioDao municipioDao) {this.municipioDao = municipioDao;}
	
	//-----------------------------------------------------------
	//-----------------------Abono-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Abono findAbonoById(long id) throws Exception {
		try {
			return getAbonoDao().findAbonoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findAbonoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Abono</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Abono> findAllAbonos() throws Exception {
		try {
			return getAbonoDao().findAllAbonos();
		} catch (RuntimeException e) {
			throw new Exception("findAllAbonos failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Abono> findAllAbonos(long idCredito) throws Exception {
		try {
			return getAbonoDao().findAllAbonos(idCredito);
		} catch (RuntimeException e) {
			throw new Exception("findAllAbonos failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAbono(Abono abono) throws Exception {
		try {
			getAbonoDao().persistAbono(abono);
		} catch (RuntimeException e) {
			throw new Exception("persistAbono failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAbono(Abono abono) throws Exception {
		try {
			getAbonoDao().removeAbono(abono);
		} catch (RuntimeException e) {
			throw new Exception("removeAbono failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------Credito-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Credito findCreditoById(long id) throws Exception {
		try {
			return getCreditoDao().findCreditoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findCreditoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Credito</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Credito> findAllCreditos() throws Exception {
		try {
			return getCreditoDao().findAllCreditos();
		} catch (RuntimeException e) {
			throw new Exception("findAllCreditos failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Credito> findAllCreditosXCliente(String documentoPers, Integer idTipoDoc) throws Exception {
		try {
			return getCreditoDao().findAllCreditosXCliente(documentoPers, idTipoDoc);
		} catch (RuntimeException e) {
			throw new Exception("findAllCreditosXCliente failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCredito(Credito credito) throws Exception {
		try {
			getCreditoDao().persistCredito(credito);
		} catch (RuntimeException e) {
			throw new Exception("persistCredito failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCredito(Credito credito) throws Exception {
		try {
			getCreditoDao().removeCredito(credito);
		} catch (RuntimeException e) {
			throw new Exception("removeCredito failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------creditotipodescuento-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Creditotipodescuento findCreditotipodescuentoById(com.software2g.vo.CreditotipodescuentoPK id) throws Exception {
		try {
			return getCreditoTipoDesDao().findCreditotipodescuentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findCreditotipodescuentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Creditotipodescuento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Creditotipodescuento> findAllCreditotipodescuentos() throws Exception {
		try {
			return getCreditoTipoDesDao().findAllCreditotipodescuentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllCreditotipodescuentos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCreditotipodescuento(Creditotipodescuento creditotipodescuento) throws Exception {
		try {
			getCreditoTipoDesDao().persistCreditotipodescuento(creditotipodescuento);
		} catch (RuntimeException e) {
			throw new Exception("persistCreditotipodescuento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCreditotipodescuento(Creditotipodescuento creditotipodescuento) throws Exception {
		try {
			getCreditoTipoDesDao().removeCreditotipodescuento(creditotipodescuento);
		} catch (RuntimeException e) {
			throw new Exception("removeCreditotipodescuento failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------donacionobjeto-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Donacionobjeto findDonacionobjetoById(com.software2g.vo.DonacionobjetoPK id) throws Exception {
		try {
			return getDonacionObjDao().findDonacionobjetoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDonacionobjetoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Donacionobjeto</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Donacionobjeto> findAllDonacionobjetos() throws Exception {
		try {
			return getDonacionObjDao().findAllDonacionobjetos();
		} catch (RuntimeException e) {
			throw new Exception("findAllDonacionobjetos failed: " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Donacionobjeto</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Donacionobjeto> findAllDonacionobjetos(long idDona) throws Exception {
		try {
			return getDonacionObjDao().findAllDonacionobjetos(idDona);
		} catch (RuntimeException e) {
			throw new Exception("findAllDonacionobjetos failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDonacionobjeto(Donacionobjeto donacionobjeto) throws Exception {
		try {
			getDonacionObjDao().persistDonacionobjeto(donacionobjeto);
		} catch (RuntimeException e) {
			throw new Exception("persistDonacionobjeto failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacionobjeto(Donacionobjeto donacionobjeto) throws Exception {
		try {
			getDonacionObjDao().removeDonacionobjeto(donacionobjeto);
		} catch (RuntimeException e) {
			throw new Exception("removeDonacionobjeto failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------donacion-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Donacion findDonacionById(long id) throws Exception {
		try {
			return getDonacionDao().findDonacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDonacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Donacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Donacion> findAllDonacions() throws Exception {
		try {
			List<Donacion> list = getDonacionDao().findAllDonacions();
			/*for(Donacion elem:list)
				elem.setDonacionobjetos(findAllDonacionobjetos(elem.getDonaId()));*/
			return list;
		} catch (RuntimeException e) {
			throw new Exception("findAllDonacions failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Donacion findIdDonacion(String fecha, String hora) throws Exception {
		try {
			return getDonacionDao().findIdDonacion(fecha, hora);
		} catch (RuntimeException e) {
			throw new Exception("findIdDonacion failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDonacion(Donacion donacion) throws Exception {
		try {
			getDonacionDao().persistDonacion(donacion);
		} catch (RuntimeException e) {
			//throw new Exception("persistDonacion failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacion(Donacion donacion) throws Exception {
		try {
			getDonacionDao().removeDonacion(donacion);
		} catch (RuntimeException e) {
			throw new Exception("removeDonacion failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Donacion> findDonacionIdEntidad(long idEntidad) throws Exception {
		try {
			return getDonacionDao().findDonacionIdEntidad(idEntidad);
		} catch (RuntimeException e) {
			throw new Exception("findDonacionIdEntidad failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------donacionsucursal-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Donacionsucursal findDonacionsucursalById(com.software2g.vo.DonacionsucursalPK id) throws Exception {
		try {
			return getDonacionSucursalDao().findDonacionsucursalById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDonacionsucursalById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Donacionsucursal</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Donacionsucursal> findAllDonacionsucursals() throws Exception {
		try {
			return getDonacionSucursalDao().findAllDonacionsucursals();
		} catch (RuntimeException e) {
			throw new Exception("findAllDonacionsucursals failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDonacionsucursal(Donacionsucursal donacionsucursal) throws Exception {
		try {
			getDonacionSucursalDao().persistDonacionsucursal(donacionsucursal);
		} catch (RuntimeException e) {
			throw new Exception("persistDonacionsucursal failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacionsucursal(Donacionsucursal donacionsucursal) throws Exception {
		try {
			getDonacionSucursalDao().removeDonacionsucursal(donacionsucursal);
		} catch (RuntimeException e) {
			throw new Exception("removeDonacionsucursal failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------entnidaddonate-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Entidaddonante findEntidaddonanteById(long id) throws Exception {
		try {
			return getEntidadDonanteDao().findEntidaddonanteById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEntidaddonanteById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Entidaddonante</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Entidaddonante> findAllEntidaddonantes() throws Exception {
		try {
			return getEntidadDonanteDao().findAllEntidaddonantes();
		} catch (RuntimeException e) {
			throw new Exception("findAllEntidaddonantes failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEntidaddonante(Entidaddonante entidaddonante) throws Exception {
		try {
			getEntidadDonanteDao().persistEntidaddonante(entidaddonante);
		} catch (RuntimeException e) {
			throw new Exception("persistEntidaddonante failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEntidaddonante(Entidaddonante entidaddonante) throws Exception {
		try {
			getEntidadDonanteDao().removeEntidaddonante(entidaddonante);
		} catch (RuntimeException e) {
			throw new Exception("removeEntidaddonante failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------objeto-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Objeto findObjetoById(long id) throws Exception {
		try {
			return getObjetoDao().findObjetoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findObjetoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Objeto</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Objeto> findAllObjetos() throws Exception {
		try {
			return getObjetoDao().findAllObjetos();
		} catch (RuntimeException e) {
			throw new Exception("findAllObjetos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistObjeto(Objeto objeto) throws Exception {
		try {
			getObjetoDao().persistObjeto(objeto);
		} catch (RuntimeException e) {
			throw new Exception("persistObjeto failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeObjeto(Objeto objeto) throws Exception {
		try {
			getObjetoDao().removeObjeto(objeto);
		} catch (RuntimeException e) {
			throw new Exception("removeObjeto failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------pagare-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Pagare findPagareById(long id) throws Exception {
		try {
			return getPagareDao().findPagareById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPagareById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Pagare</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pagare> findAllPagares() throws Exception {
		try {
			return getPagareDao().findAllPagares();
		} catch (RuntimeException e) {
			throw new Exception("findAllPagares failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pagare> findAllTitularesCredito(String datoFind, String tipoFind) throws Exception {
		try {
			return getPagareDao().findAllTitularesCredito(datoFind, tipoFind);
		} catch (RuntimeException e) {
			throw new Exception("findAllPagares failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPagare(Pagare pagare) throws Exception {
		try {
			getPagareDao().persistPagare(pagare);
		} catch (RuntimeException e) {
			throw new Exception("persistPagare failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePagare(Pagare pagare) throws Exception {
		try {
			getPagareDao().removePagare(pagare);
		} catch (RuntimeException e) {
			throw new Exception("removePagare failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------presupuestodonante-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Presupuestodonacion findPresupuestodonacionById(com.software2g.vo.PresupuestodonacionPK id) throws Exception {
		try {
			return getPresupuestoDonacionDao().findPresupuestodonacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPresupuestodonacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Presupuestodonacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Presupuestodonacion> findAllPresupuestodonacions() throws Exception {
		try {
			return getPresupuestoDonacionDao().findAllPresupuestodonacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllPresupuestodonacions failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Presupuestodonacion> findAllPresupuestodonacions(long forengKey, int tipo) throws Exception {
		try {
			return getPresupuestoDonacionDao().findAllPresupuestodonacions(forengKey, tipo);
		} catch (RuntimeException e) {
			throw new Exception("findAllPresupuestodonacions failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPresupuestodonacion(Presupuestodonacion presupuestodonacion) throws Exception {
		try {
			getPresupuestoDonacionDao().persistPresupuestodonacion(presupuestodonacion);
		} catch (RuntimeException e) {
			throw new Exception("persistPresupuestodonacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuestodonacion(Presupuestodonacion presupuestodonacion) throws Exception {
		try {
			getPresupuestoDonacionDao().removePresupuestodonacion(presupuestodonacion);
		} catch (RuntimeException e) {
			throw new Exception("removePresupuestodonacion failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------presupuesto-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Presupuesto findPresupuestoById(long id) throws Exception {
		try {
			return getPresupuestoDao().findPresupuestoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPresupuestoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Presupuesto</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Presupuesto> findAllPresupuestos() throws Exception {
		try {
			return getPresupuestoDao().findAllPresupuestos();
		} catch (RuntimeException e) {
			throw new Exception("findAllPresupuestos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPresupuesto(Presupuesto presupuesto) throws Exception {
		try {
			getPresupuestoDao().persistPresupuesto(presupuesto);
		} catch (RuntimeException e) {
			throw new Exception("persistPresupuesto failed: " + e.getMessage());
		}
	}
	
	public Presupuesto persistPresupuesto(Presupuesto presupuesto, String usuario) throws Exception {
		try {
			presupuesto.setPresFechamodificacion(ValidaString.fechaSystem());
			presupuesto.setPresHora(ValidaString.horaSystem());
			presupuesto.setPresRegistradopor(usuario);
			getPresupuestoDao().persistPresupuesto(presupuesto);
			if(presupuesto.getPresId()<=0)
				presupuesto=getPresupuestoDao().findPresupuestos(presupuesto.getPresFechamodificacion(), presupuesto.getPresHora());
		} catch (RuntimeException e) {
			throw new Exception("persistPresupuesto failed: " + e.getMessage());
		}
		System.out.println("--------------------------------------------------------");
		ValidaString.imprimirObject(presupuesto);
		System.out.println("--------------------------------------------------------");
		return presupuesto;
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuesto(Presupuesto presupuesto) throws Exception {
		try {
			getPresupuestoDao().removePresupuesto(presupuesto);
		} catch (RuntimeException e) {
			throw new Exception("removePresupuesto failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------presupuestosucursal-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Presupuestosucursal findPresupuestosucursalById(long id) throws Exception {
		try {
			return getPresupuestoSucursalDao().findPresupuestosucursalById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPresupuestosucursalById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Presupuestosucursal</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Presupuestosucursal> findAllPresupuestosucursals() throws Exception {
		try {
			return getPresupuestoSucursalDao().findAllPresupuestosucursals();
		} catch (RuntimeException e) {
			throw new Exception("findAllPresupuestosucursals failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPresupuestosucursal(Presupuestosucursal presupuestosucursal) throws Exception {
		try {
			getPresupuestoSucursalDao().persistPresupuestosucursal(presupuestosucursal);
		} catch (RuntimeException e) {
			throw new Exception("persistPresupuestosucursal failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuestosucursal(Presupuestosucursal presupuestosucursal) throws Exception {
		try {
			getPresupuestoSucursalDao().removePresupuestosucursal(presupuestosucursal);
		} catch (RuntimeException e) {
			throw new Exception("removePresupuestosucursal failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------seguro-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Seguro findSeguroById(long id) throws Exception {
		try {
			return getSeguroDao().findSeguroById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSeguroById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Seguro</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Seguro> findAllSeguros() throws Exception {
		try {
			return getSeguroDao().findAllSeguros();
		} catch (RuntimeException e) {
			throw new Exception("findAllSeguros failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeguro(Seguro seguro) throws Exception {
		try {
			getSeguroDao().persistSeguro(seguro);
		} catch (RuntimeException e) {
			throw new Exception("persistSeguro failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeguro(Seguro seguro) throws Exception {
		try {
			getSeguroDao().removeSeguro(seguro);
		} catch (RuntimeException e) {
			throw new Exception("removeSeguro failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------sucursal-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Sucursal findSucursalById(long id) throws Exception {
		try {
			return getSucursalDao().findSucursalById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSucursalById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Sucursal</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Sucursal> findAllSucursals() throws Exception {
		try {
			List<Sucursal> result = getSucursalDao().findAllSucursals();
			for(Sucursal elem:result){
				List<Object[]> obj = getMunicipioDao().findDatosMunicipio(elem.getSucuUbicacion());
				for(Object[] elem1:obj){
					elem.setNombreUbicacion(elem1[0].toString());
					elem.setDptoId(Long.parseLong(elem1[1].toString()));
					elem.setPaisId(Long.parseLong(elem1[2].toString()));
				}
			}
			return result;
		} catch (RuntimeException e) {
			throw new Exception("findAllSucursals failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSucursal(Sucursal sucursal) throws Exception {
		try {
			getSucursalDao().persistSucursal(sucursal);
		} catch (RuntimeException e) {
			throw new Exception("persistSucursal failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSucursal(Sucursal sucursal) throws Exception {
		try {
			getSucursalDao().removeSucursal(sucursal);
		} catch (RuntimeException e) {
			throw new Exception("removeSucursal failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipocreditoseguroadquirido-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipocreditoseguroadquirido findTipocreditoseguroadquiridoById(com.software2g.vo.TipocreditoseguroadquiridoPK id) throws Exception {
		try {
			return getTipoCreSegAdquiridoDao().findTipocreditoseguroadquiridoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipocreditoseguroadquiridoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipocreditoseguroadquirido</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipocreditoseguroadquirido> findAllTipocreditoseguroadquiridos() throws Exception {
		try {
			return getTipoCreSegAdquiridoDao().findAllTipocreditoseguroadquiridos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipocreditoseguroadquiridos failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipocreditoseguroadquirido> findAllTipocreditoseguroadquiridos(long idTipoCredito) throws Exception {
		try {
			return getTipoCreSegAdquiridoDao().findAllTipocreditoseguroadquiridos(idTipoCredito);
		} catch (RuntimeException e) {
			throw new Exception("findAllTipocreditoseguroadquiridos failed: " + e.getMessage());
		}
	}
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipocreditoseguroadquirido(Tipocreditoseguroadquirido tipocreditoseguroadquirido) throws Exception {
		try {
			getTipoCreSegAdquiridoDao().persistTipocreditoseguroadquirido(tipocreditoseguroadquirido);
		} catch (RuntimeException e) {
			throw new Exception("persistTipocreditoseguroadquirido failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipocreditoseguroadquirido(Tipocreditoseguroadquirido tipocreditoseguroadquirido) throws Exception {
		try {
			getTipoCreSegAdquiridoDao().removeTipocreditoseguroadquirido(tipocreditoseguroadquirido);
		} catch (RuntimeException e) {
			throw new Exception("removeTipocreditoseguroadquirido failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipocredito-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipocredito findTipocreditoById(long id) throws Exception {
		try {
			return getTipoCreditoDao().findTipocreditoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipocreditoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipocredito</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipocredito> findAllTipocreditos() throws Exception {
		try {
			return getTipoCreditoDao().findAllTipocreditos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipocreditos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipocredito(Tipocredito tipocredito) throws Exception {
		try {
			getTipoCreditoDao().persistTipocredito(tipocredito);
		} catch (RuntimeException e) {
			throw new Exception("persistTipocredito failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipocredito(Tipocredito tipocredito) throws Exception {
		try {
			getTipoCreditoDao().removeTipocredito(tipocredito);
		} catch (RuntimeException e) {
			throw new Exception("removeTipocredito failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipodescuento-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodescuento findTipodescuentoById(long id) throws Exception {
		try {
			return getTipoDescuentoDao().findTipodescuentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodescuentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodescuento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodescuento> findAllTipodescuentos() throws Exception {
		try {
			return getTipoDescuentoDao().findAllTipodescuentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodescuentos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodescuento(Tipodescuento tipodescuento) throws Exception {
		try {
			getTipoDescuentoDao().persistTipodescuento(tipodescuento);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodescuento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodescuento(Tipodescuento tipodescuento) throws Exception {
		try {
			getTipoDescuentoDao().removeTipodescuento(tipodescuento);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodescuento failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipopagare-------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipopagare findTipopagareById(long id) throws Exception {
		try {
			return getTipoPagareDao().findTipopagareById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipopagareById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipopagare</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipopagare> findAllTipopagares() throws Exception {
		try {
			return getTipoPagareDao().findAllTipopagares();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipopagares failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipopagare(Tipopagare tipopagare) throws Exception {
		try {
			getTipoPagareDao().persistTipopagare(tipopagare);
		} catch (RuntimeException e) {
			throw new Exception("persistTipopagare failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipopagare(Tipopagare tipopagare) throws Exception {
		try {
			getTipoPagareDao().removeTipopagare(tipopagare);
		} catch (RuntimeException e) {
			throw new Exception("removeTipopagare failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------	
	
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
	
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Persona> findAllPersonas(String datoFind, String tipoFind)throws Exception {
		try {
			return getPersonaDao().findAllPersonas(datoFind, tipoFind);
		} catch (RuntimeException e) {
			throw new Exception("findAllTipopagares failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Persona findPersonaById(java.lang.Integer id) throws Exception {
		try {
			return getPersonaDao().findPersonaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Abono liquidacionPagoCredito(Credito creditoVO)throws Exception {
		try {
			Abono abonoVO = new Abono();
			double diasLiquidados = this.diasLiquidados(creditoVO.getCredFechaultimopago(),
					creditoVO.getFechaALiquidar()==null||creditoVO.getFechaALiquidar().equals("")?ValidaString.fechaSystem():creditoVO.getFechaALiquidar());
			double diasMora = this.diasMora(diasLiquidados);
			abonoVO.setCredito(creditoVO);
			abonoVO.setDiasLiquidados(diasLiquidados);
			abonoVO.setDiasMora(diasMora);
			abonoVO.setAbonValorinteres(this.valorInteresCorrienteCredito(creditoVO.getCredSaldo(), 
					creditoVO.getTipocredito().getTicrTasainteresvencido(), diasLiquidados));
			abonoVO.setAbonValorinteresmora(this.valorInteresMoraCredito(creditoVO.getCredSaldo(), 
					creditoVO.getTipocredito().getTicrInteresmoramesven(), diasMora));
			abonoVO.setAbonValorseguro(this.valorSeguroCredito());
			abonoVO.setAbonOtrocargo(this.valorOtrosCargosCredito());
			abonoVO.setAbonValorcapital(this.valorAbonoCapital(creditoVO.getCredMontocredito(), 
					creditoVO.getTipocredito().getTicrTiempomes(), diasLiquidados));
			abonoVO.setAbonValortotal(this.valorTotalaPagar(abonoVO.getAbonValorcapital(), 
					abonoVO.getAbonValorinteres(), abonoVO.getAbonValorinteresmora(), 
					abonoVO.getAbonValorseguro(), abonoVO.getAbonOtrocargo()));
			return abonoVO;
		} catch (RuntimeException e) {
			throw new Exception("liquidacionPagoCredito failed with the id " + creditoVO + ": " + e.getMessage());
		}
	}
	
	/**
	 * Metodo que obtiene los dias a liquidar entre dos fechas especificas
	 * @param fechaUltPago
	 * @param fechaALiquidar
	 * @return
	 */
	public double diasLiquidados(String fechaUltPago, String fechaALiquidar){
		Calendar fechaInicio = new GregorianCalendar(Integer.parseInt(fechaUltPago.substring(0, 4)), 
				Integer.parseInt(fechaUltPago.substring(5, 7)),
				Integer.parseInt(fechaUltPago.substring(8, 10)));
		Calendar fechaFinal = new GregorianCalendar(Integer.parseInt(fechaALiquidar.substring(0, 4)),  
				Integer.parseInt(fechaALiquidar.substring(5, 7)),
				Integer.parseInt(fechaALiquidar.substring(8, 10)));
		return ( fechaFinal.getTimeInMillis() - fechaInicio.getTimeInMillis() ) / ConstantesAplicativo.MILLSECS_PER_DAY ;
	}
	
	public double diasLiquidados(String fechaUltPago, double valoraPagar){
		return 0;
	}
	
	
	public double diasMora(double diasLiquidados){
		double diasMora = diasLiquidados - ConstantesAplicativo.DIAS_MES; 
		return diasMora>0?diasMora:0;
	}
	
	public double valorInteresCorrienteCredito(double saldoCredito, double interesCorriente, double diasLiquidados){
		try{
			DecimalFormat  df = new DecimalFormat("###########0.00");
			String valor = df.format(diasLiquidados>=30?(saldoCredito*interesCorriente)/100:(((saldoCredito*interesCorriente)/100)*diasLiquidados)/ConstantesAplicativo.DIAS_MES);
			return Double.parseDouble(valor.replace(',','.'));
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public double valorInteresMoraCredito(double saldoCredito, double interesMora, double diasMora){
		DecimalFormat  df = new DecimalFormat("###########0.00"); 
		String valor = df.format(diasMora>0?((saldoCredito*interesMora)/100)*(diasMora/ConstantesAplicativo.DIAS_MES):0);
		return Double.parseDouble(valor.replace(',','.'));
	}
	
	public double valorSeguroCredito(){
		return 0;
	}
	
	public double valorOtrosCargosCredito(){
		return 0;
	}
	
	public double valorDescuentosCredito(){
		return 0;
	}
	
	public double valorAbonoCapital(double montoCredito, double periocidadCobro, double diasLiquidados){
		DecimalFormat  df = new DecimalFormat("#################0.00"); 
		String valor = df.format((montoCredito/periocidadCobro)*(diasLiquidados/ConstantesAplicativo.DIAS_MES));
		return Double.parseDouble(valor.replace(',','.'));
	}
	
	public double valorTotalaPagar(double abonoCapital, double valorIntCorriente, double valorIntMora, double valorSeguro, double valorOtroRec){
		DecimalFormat  df = new DecimalFormat("###########0.00");
		String valor = df.format(abonoCapital+valorIntCorriente+valorIntMora+valorSeguro+valorOtroRec);
		return Double.parseDouble(valor.replace(',','.'));
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public String obtenerFechaCorte(Credito creditoVO, double valorapagar)throws Exception{
		
		double diasLiquidados = this.valorAbonoCapital(creditoVO.getCredMontocredito(), creditoVO.getTipocredito().getTicrTiempomes(), 
														creditoVO.getCredSaldo(), creditoVO.getTipocredito().getTicrTasainteresvencido(), 
														creditoVO.getTipocredito().getTicrInteresmoramesven(), 
														1, 0, valorapagar);
		return ValidaString.obtenerFechaCorte(Integer.parseInt(creditoVO.getCredFechaultimopago().substring(0, 4)), 
											  Integer.parseInt(creditoVO.getCredFechaultimopago().substring(5, 7)), 
											  Integer.parseInt(creditoVO.getCredFechaultimopago().substring(8, 10)), (int) diasLiquidados);
	}
	
	
	
	private double valorAbonoCapital(double montoCredito, double periocidadCobro, double saldoCredito, double interesCorriente, double interesMora, 
									double diasLiquidados, double diasMora, double valorapagar){
		double abonoCapital = (montoCredito/periocidadCobro)*(diasLiquidados/ConstantesAplicativo.DIAS_MES);
		double valorIntCorriente = diasLiquidados>=30?(saldoCredito*interesCorriente)/100:(((saldoCredito*interesCorriente)/100)*diasLiquidados)/ConstantesAplicativo.DIAS_MES;
		double valorIntMora = diasMora>0?((saldoCredito*interesMora)/100)*(diasMora/ConstantesAplicativo.DIAS_MES):0;
		if((abonoCapital+valorIntCorriente+valorIntMora)>valorapagar)
			return diasLiquidados;
		else
			return valorAbonoCapital(montoCredito, periocidadCobro, saldoCredito, interesCorriente, interesMora, 
					(diasLiquidados+1), (diasLiquidados+1)>30?(diasMora+1):0, valorapagar);
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
	
}
