package com.software2g.contable.facade;

import java.util.List;

import com.software2g.vo.Abono;
import com.software2g.vo.Credito;
import com.software2g.vo.Creditotipodescuento;
import com.software2g.vo.Donacion;
import com.software2g.vo.Donacionobjeto;
import com.software2g.vo.Donacionsucursal;
import com.software2g.vo.Entidaddonante;
import com.software2g.vo.Objeto;
import com.software2g.vo.Pagare;
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

public interface IGestionFacadeContable {
	//-----------------------------------------------------------
	//-----------------------Abono-------------------------------
	public Abono findAbonoById(long id) throws Exception;
	public List<Abono> findAllAbonos() throws Exception;
	public List<Abono> findAllAbonos(long idCredito) throws Exception;
	public void persistAbono(Abono abono) throws Exception;
	public void removeAbono(Abono abono) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------Credito-------------------------------
	public Credito findCreditoById(long id) throws Exception;
	public List<Credito> findAllCreditos() throws Exception;
	public List<Credito> findAllCreditosXCliente(String documentoPers, Integer idTipoDoc) throws Exception;
	public void persistCredito(Credito credito) throws Exception;
	public void removeCredito(Credito credito) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------creditotipodescuento-------------------------------
	public Creditotipodescuento findCreditotipodescuentoById(com.software2g.vo.CreditotipodescuentoPK id) throws Exception;
	public List<Creditotipodescuento> findAllCreditotipodescuentos() throws Exception;
	public void persistCreditotipodescuento(Creditotipodescuento creditotipodescuento) throws Exception;
	public void removeCreditotipodescuento(Creditotipodescuento creditotipodescuento) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------donacionobjeto-------------------------------
	public Donacionobjeto findDonacionobjetoById(com.software2g.vo.DonacionobjetoPK id) throws Exception;
	public List<Donacionobjeto> findAllDonacionobjetos() throws Exception;
	public List<Donacionobjeto> findAllDonacionobjetos(long idDona) throws Exception;
	public void persistDonacionobjeto(Donacionobjeto donacionobjeto) throws Exception;
	public void removeDonacionobjeto(Donacionobjeto donacionobjeto) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------donacion-------------------------------
	public Donacion findDonacionById(long id) throws Exception;
	public List<Donacion> findAllDonacions() throws Exception;
	public Donacion findIdDonacion(String fecha, String hora) throws Exception;
	public void persistDonacion(Donacion donacion) throws Exception;
	public void removeDonacion(Donacion donacion) throws Exception;
	public List<Donacion> findDonacionIdEntidad(long idEntidad) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------donacionsucursal-------------------------------
	public Donacionsucursal findDonacionsucursalById(com.software2g.vo.DonacionsucursalPK id) throws Exception;
	public List<Donacionsucursal> findAllDonacionsucursals() throws Exception;
	public void persistDonacionsucursal(Donacionsucursal donacionsucursal) throws Exception;
	public void removeDonacionsucursal(Donacionsucursal donacionsucursal) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------entnidaddonate-------------------------------
	public Entidaddonante findEntidaddonanteById(long id) throws Exception;
	public List<Entidaddonante> findAllEntidaddonantes() throws Exception;
	public void persistEntidaddonante(Entidaddonante entidaddonante) throws Exception;
	public void removeEntidaddonante(Entidaddonante entidaddonante) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------objeto-------------------------------
	public Objeto findObjetoById(long id) throws Exception;
	public List<Objeto> findAllObjetos() throws Exception;
	public void persistObjeto(Objeto objeto) throws Exception;
	public void removeObjeto(Objeto objeto) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------pagare-------------------------------
	public Pagare findPagareById(long id) throws Exception;
	public List<Pagare> findAllPagares() throws Exception;
	public void persistPagare(Pagare pagare) throws Exception;
	public void removePagare(Pagare pagare) throws Exception;
	public List<Pagare> findAllTitularesCredito(String datoFind, String tipoFind) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------presupuestodonante-------------------------------
	public Presupuestodonacion findPresupuestodonacionById(com.software2g.vo.PresupuestodonacionPK id) throws Exception;
	public List<Presupuestodonacion> findAllPresupuestodonacions() throws Exception;
	public void persistPresupuestodonacion(Presupuestodonacion presupuestodonacion) throws Exception;
	public void removePresupuestodonacion(Presupuestodonacion presupuestodonacion) throws Exception;
	public List<Presupuestodonacion> findAllPresupuestodonacions(long forengKey, int tipo) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------presupuesto-------------------------------
	public Presupuesto findPresupuestoById(long id) throws Exception;
	public List<Presupuesto> findAllPresupuestos() throws Exception;
	public void persistPresupuesto(Presupuesto presupuesto) throws Exception;
	public Presupuesto persistPresupuesto(Presupuesto presupuesto, String usuario) throws Exception;
	public void removePresupuesto(Presupuesto presupuesto) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------presupuestosucursal-------------------------------
	public Presupuestosucursal findPresupuestosucursalById(long id) throws Exception;
	public List<Presupuestosucursal> findAllPresupuestosucursals() throws Exception;
	public void persistPresupuestosucursal(Presupuestosucursal presupuestosucursal) throws Exception;
	public void removePresupuestosucursal(Presupuestosucursal presupuestosucursal) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------seguro-------------------------------
	public Seguro findSeguroById(long id) throws Exception;
	public List<Seguro> findAllSeguros() throws Exception;
	public void persistSeguro(Seguro seguro) throws Exception;
	public void removeSeguro(Seguro seguro) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------sucursal-------------------------------
	public Sucursal findSucursalById(long id) throws Exception;
	public List<Sucursal> findAllSucursals() throws Exception;
	public void persistSucursal(Sucursal sucursal) throws Exception;
	public void removeSucursal(Sucursal sucursal) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipocreditoseguroadquirido-------------------------------
	public Tipocreditoseguroadquirido findTipocreditoseguroadquiridoById(com.software2g.vo.TipocreditoseguroadquiridoPK id) throws Exception;
	public List<Tipocreditoseguroadquirido> findAllTipocreditoseguroadquiridos() throws Exception;
	public List<Tipocreditoseguroadquirido> findAllTipocreditoseguroadquiridos(long idTipoCredito) throws Exception;
	public void persistTipocreditoseguroadquirido(Tipocreditoseguroadquirido tipocreditoseguroadquirido) throws Exception;
	public void removeTipocreditoseguroadquirido(Tipocreditoseguroadquirido tipocreditoseguroadquirido) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipocredito-------------------------------
	public Tipocredito findTipocreditoById(long id) throws Exception;
	public List<Tipocredito> findAllTipocreditos() throws Exception;
	public void persistTipocredito(Tipocredito tipocredito) throws Exception;
	public void removeTipocredito(Tipocredito tipocredito) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipodescuento-------------------------------
	public Tipodescuento findTipodescuentoById(long id) throws Exception;
	public List<Tipodescuento> findAllTipodescuentos() throws Exception;
	public void persistTipodescuento(Tipodescuento tipodescuento) throws Exception;
	public void removeTipodescuento(Tipodescuento tipodescuento) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------tipopagare-------------------------------
	public Tipopagare findTipopagareById(long id) throws Exception;
	public List<Tipopagare> findAllTipopagares() throws Exception;
	public void persistTipopagare(Tipopagare tipopagare) throws Exception;
	public void removeTipopagare(Tipopagare tipopagare) throws Exception;
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------persona-------------------------------
	public List<Persona> findAllPersonas(String datoFind, String tipoFind)throws Exception;
	public Persona findPersonaById(java.lang.Integer id) throws Exception;
	//-----------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad TipoDocumento
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception;
	public List<Tipodocumento> findAllTipodocumentos() throws Exception;
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception;
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception;
	//FIN --- Metodos Entidad TipoDocumento
	//--------------------------------------------------------------------------
	
	
	public Abono liquidacionPagoCredito(Credito creditoVO)throws Exception;
	public String obtenerFechaCorte(Credito creditoVO, double valorapagar)throws Exception;
}
